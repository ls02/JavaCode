import java.util.Scanner;
import java.lang.String;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-05-29
 * Time: 16:51
 */
public class TestDemo {
    /***
     * 显示一个数的偶数二进制位和奇数二进制位
     */
    static void Test1() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            System.out.print("二进制位奇数:");
            int flag1 = 0;
            for (int i = 1; i <= 31; i += 2) {
                if (flag1 == 4) {
                    System.out.printf(" ");
                    flag1 = 0;
                }

                System.out.print((x >> i) & 1);
                flag1++;
            }
            System.out.println();

            System.out.print("二进制位偶数:");
            int flag2 = 0;
            for (int i = 0; i <= 30; i += 2) {
                if (flag2 == 4) {
                    System.out.printf(" ");
                    flag2 = 0;
                }

                System.out.print((x >> i) & 1);
                flag2++;
            }
            System.out.println();
        }

        sc.close();
    }

    static void Test2() {
        Scanner sc = new Scanner(System.in);
        int count = 3;

        while (count != 0) {
            System.out.print("请输入密码:>");
            String passWord = sc.nextLine();
            if (passWord.equals("123 456")) {
                System.out.println("登录成功!");
                break;
            } else {
                count--;
                System.out.println("登录失败!");

                if (count != 0) {
                    System.out.println("你还有" + count + "次机会!");
                }
            }
        }

        sc.close();
    }

    static void Test3() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int x = sc.nextInt();

            while (x > 0) {
                System.out.printf("%d ", x % 10);

                x /= 10;
            }

            System.out.println();
        }

        sc.close();
    }

    static void Test4() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%-2d\t", i, j, i * j);
            }
            System.out.println();
        }

        sc.close();
    }

    /**
     * 找只出现一次的数
     * @param arr 传递一个数组
     * @return 返回只出现一次的值
     */
    static int FindNumOnce(int[] arr) {
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            temp ^= arr[i];
        }

        return temp;
    }

    static void Test5() {
        int[] arr = { 1, 1, 2, 2, 5, 4, 4 };

        System.out.println(FindNumOnce(arr));
    }

    static void Test6() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int x = 0;
            int y = 1;
            int i = n;

            while (i > 0) {
                int temp = x + y;
                x = y;
                y = temp;

                i--;
            }

            System.out.println("第" + n + "项斐波那契数列:>" + x);
        }

        sc.close();
    }

    static void Test7() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int sum = 0;

            for (int j = 1; j <= n; j++) {
                int ret = 1;
                int i = j;

                while (i > 0) {
                    ret *= i;
                    i--;
                }

                sum += ret;
            }

            System.out.println(n + "的阶乘和为:>" + sum);
        }

        sc.close();
    }

    static void Test8() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            int ret = 1;
            int i = n;

            while (i > 0) {
                ret *= i;
                i--;
            }

            System.out.println(n + "的阶乘为:>" + ret);
        }

        sc.close();
    }

    public static void main(String[] args) {
        Test8();
//        Test7();
//        Test6();
//        Test5();
//        Test4();
//        Test3();
//        Test2();
//        Test1();
    }
}
