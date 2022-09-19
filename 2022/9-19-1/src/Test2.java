/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-09-19
 * Time: 13:13
 */
 class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello");
    }
}

public class Test2 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread());

        t.start();
    }
}
