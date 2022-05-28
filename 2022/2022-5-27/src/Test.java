/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-05-27
 * Time: 18:24
 */
public class Test {
    static void Test1()
    {
        System.out.println("hello" + " " + "World" + (1 + 2));
        System.out.println(1 + " " + 2 + "hello");
    }

    static void Test2()
    {
        String s = "100";
        int ret = new Integer(s);

        System.out.println(ret);
//        System.out.println(s);

        System.out.println(1 & 3);
    }

    public static void main(String[] args) {
//        Test1();
        Test2();

    }
}
