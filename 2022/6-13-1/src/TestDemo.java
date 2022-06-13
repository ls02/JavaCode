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
    public static void main(String[] args) throws InterruptedException {
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
}
