/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-15
 * Time: 11:01
 */

class Queue {
    private int[] arr = new int[1000];
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private Object lock = new Object();

    public void put(int val) throws InterruptedException {
        synchronized(lock) {
            while (size == arr.length) {
                lock.wait();
            }

            arr[tail] = val;
            tail++;
            tail %= arr.length;
            size++;
            lock.notify();
        }
    }

    public int pop() throws InterruptedException {
        int ret = 0;
        synchronized(lock) {
            while (size == 0) {
                lock.wait();
            }

            ret = arr[head];
            head++;
            head %= arr.length;
            size--;

            lock.notify();
        }

        return ret;
    }
}

public class TestDemo {
    static void Test1() throws InterruptedException {

    }

    static void Test2() throws InterruptedException {
        Object obj = new Object();

        synchronized (obj) {
            obj.wait();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Queue q = new Queue();
        //生产者
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 1000; i++) {
                    System.out.println("生产元素:" + i);

                    try {
                        q.put(i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread1.start();

        //消费者
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int ret = q.pop();
                        System.out.println("消费元素：" + ret);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread2.start();

        thread1.join();
        thread2.join();
    }
}
