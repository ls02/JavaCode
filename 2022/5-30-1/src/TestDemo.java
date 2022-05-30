import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-05-30
 * Time: 10:18
 * @author 86176
 */

public class TestDemo {

    static void Test1() {
        int[] arr = { 1, 2, 3, 4 };
        int[] copy = arr.clone();
        System.out.println(Arrays.toString(copy));
//        int[] arr = { 1, 2, 3, 4 };
//        int[] copy = new int[arr.length];
//        System.arraycopy(arr, 0, copy, 0, arr.length);
//        System.out.println(Arrays.toString(copy));
//        int[] arr = { 1, 2, 3, 4 };
//        int[] ret = Arrays.copyOf(arr, arr.length * 2);
//        System.out.println(Arrays.toString(ret));
    }

    static int Max(int a, int b) {
        return a > b ? a : b;
    }

    static double Max(double a, double b) {
        return a > b ? a : b;
    }

    static void Test2() {
        System.out.println(Max(1, 3));
        System.out.println(Max(2.3, 4.5));
    }

    static int Add(int a, int b){
        return a + b;
    }

    static double Add(double a, double b, double c) {
        return a + b + c;
    }

    static void Test3() {
        System.out.println(Add(2, 4));
        System.out.println(Add(2.3 ,5.3, 5.2));
    }

    public static void main(String[] args) {
        Test3();
//        Test2();
//        Test1();
    }
}
