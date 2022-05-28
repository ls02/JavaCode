import java.util.Scanner;
import java.util.Random;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-05-28
 * Time: 14:17
 */
public class TestDemo {
    static void Test1() {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        System.out.println(str);
//        System.out.println("hello");
    }

    /*
    * 判断是否是润年的程序
    */
    static void Test2() {
        //定义也给输入流对象并打开标准输入流
        Scanner scanner = new Scanner(System.in);
        //从标准输入流读取一个整型
        int year = scanner.nextInt();

        if ((year % 400 == 0 && year % 100 != 0)
                || year % 4 == 0) {
            System.out.println(year + "是润年!");
        } else {
            System.out.println(year + "不是润年!");
        }

        //关闭标注输入流
        scanner.close();
    }

    static void Test3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = 1;
        int i = 1;
        int sum = 0;
        int j = 1;

        while (i <= n) {
            j = 1;
            ret = 1;

            while (j <= i) {
                ret *= j;
                j++;
            }
            sum += ret;
            i++;
        }

        System.out.println(n + "阶乘的和:" + sum);

    }

    static void Test4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i);
            }
        }
    }

    static void Test5() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int target = random.nextInt(100);

        while (true) {
            System.out.println("请猜数字(1-100):>");
            int num = sc.nextInt();

            if (num > target) {
                System.out.println("猜大了！");
            } else if (num < target) {
                System.out.println("猜小了！");
            } else {
                System.out.println("恭喜你猜对了！");

                break;
            }
        }

        sc.close();
    }

    static void Test6() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%-2d\t", i, j, i * j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Test6();
//        Test5();
        //Test5();
//        Test4();
//        Test3();
//        Test2();
//        Test1();
    }
}
