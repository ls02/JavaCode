import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-05-29
 * Time: 16:51
 */
public class TestDemo {

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
    }

    public static void main(String[] args) {
        Test1();
    }
}
