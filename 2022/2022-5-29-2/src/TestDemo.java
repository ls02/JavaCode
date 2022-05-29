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

    public static void main(String[] args) {
        Test3();
//        Test2();
//        Test1();
    }
}
