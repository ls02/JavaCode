/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-09-19
 * Time: 13:33
 */
public class Test3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (true) {
                System.out.println("hello thread1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread1");
        t1.start();

        Thread t2 =  new Thread(()->{
           while (true) {
               System.out.println("hello thread2");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }, "thread2");

        t2.start();
    }
}
