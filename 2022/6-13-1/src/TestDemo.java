/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-13
 * Time: 21:34
 */
//class MyThread1  extends Thread {
//    public void run() {
//        System.out.println("hello thread!");
//}

class MyThread2  extends Thread {
    public void run() {
        while (true) {
            System.out.println("hello thread!");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TestDemo {
    static void Test1() {
        Thread t = new MyThread2();
        t.start();

        while (true) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void Test2(){
        Thread t = new Thread(new MyThread2());
        t.start();
    }

    static void Test3() {
        //这个语法就是匿名内部类
        //相当于创建了一个匿名的类，这个类继承了Thread
        //此处new的实列，其实就是new了这个新的类的实列
        Thread t = new Thread() {
            public void run() {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t.start();
    }

    public static void main(String[] args) throws InterruptedException {
//        Test3();
//        Test2();
        Test1();
    }
}
