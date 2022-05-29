import java.util.Scanner;
import java.util.Random;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-05-29
 * Time: 0:13
 */
public class TestDemo {
    static void Test1() {
        int count = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 9 == 0) {
                if (i > 10) {
                    if ((i / 10) / 9 == 0) {
                        count++;
                    }
                }

                count++;
            }
        }

        System.out.println(count);
    }

    static void Test2() {
        for (int i = 1000; i <= 2000; i++) {
            if ((i % 400 == 0 && i % 100 != 0)
                || i % 4 == 0) {
                System.out.printf("%d ", i);
            }
        }
    }

    static void Test3() {
        int flag = 0;

        for (int i = 2; i < 100; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                System.out.printf("%d ", i);
            } else {
                flag = 0;
            }
        }
    }

    static boolean IsPrimeNum(int x) {
        if (x <= 1) {
            return false;
        }

        int flag = 0;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                flag = 1;
                break;
            }
        }

        if (flag == 1) {
            return false;
        } else {
            return true;
        }
    }

    static void Test4() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            if (IsPrimeNum(x)) {
                System.out.println(x + "是素数!");
            } else {
                System.out.println(x + "不是素数!");
            }
        }
    }

    static void Test5() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int age = sc.nextInt();

            if (age >= 0 && age < 18) {
                System.out.println("少年!");
            } else if (age >= 18 && age <= 28) {
                System.out.println("青年!");
            } else if (age >= 29 && age <= 55) {
                System.out.println("中年!");
            } else if (age > 55) {
                System.out.println("老年!");
            } else {
                System.out.println("输入错误！");
            }
        }
    }

    static void Test6() {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        int num = ra.nextInt(100);

        while (true) {
            System.out.println("请猜数字(1-100)>:");
            int x = sc.nextInt();

            if (x > num) {
                System.out.println("猜大了!");
            } else if (x < num) {
                System.out.println("猜小了!");
            } else {
                System.out.println("恭喜!猜对了!");
                break;
            }
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
