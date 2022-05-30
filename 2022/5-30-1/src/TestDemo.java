import java.util.Arrays;
import java.util.Scanner;

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

    static int Func(int n) {
        if (n <= 0) {
            System.out.println("输入错误!");

            return -1;
        }

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }else {
            return Func(n - 1) + Func(n - 2);
        }
    }

    static void Test4() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(Func(n));
    }


    public static void hanoi(int num, char sou, char tar, char sux) {
        int i = 1;
        // 如果圆盘数量仅有 1 个，则直接从起始柱移动到目标柱
        if (num == 1) {
            System.out.println("第" + i + "次:从" + sou + "移动到" + tar);
            i++;
        } else {
            // 递归调用 hanoi() 函数，将 num-1 个圆盘从起始柱移动到辅助柱上
            hanoi(num - 1, sou, sux, tar);
            // 将起始柱上剩余的最后一个大圆盘移动到目标柱上
            System.out.println("第" + i + "次:从" + sou + "移动到" + tar);
            i++;
            // 递归调用 hanoi() 函数，将辅助柱上的 num-1 圆盘移动到目标柱上
            hanoi(num - 1, sux, tar, sou);
        }
    }

    static void Test5() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            hanoi(n, 'A', 'B', 'C');
        }
    }

    static int FibonacciNum(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return FibonacciNum(n - 1) + FibonacciNum(n - 2);
        }
    }

    static void Test6() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            System.out.println("第" + n + "项为:>" + FibonacciNum(n));
        }
    }

    public static void main(String[] args) {
        Test6();
//        Test5();
//        Test4();
//        Test3();
//        Test2();
//        Test1();
    }
}
