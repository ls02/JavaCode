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

    public static void main(String[] args) {

        Test3();
//        Test2();
//        Test1();

    }
}