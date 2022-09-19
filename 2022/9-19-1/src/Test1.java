/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-09-19
 * Time: 10:51
 */
class MyThread extends Thread {
    @Override
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

public class Test1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();

        while (true) {
            System.out.println("I am main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
