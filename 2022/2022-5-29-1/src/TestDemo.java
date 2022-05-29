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

    public static void main(String[] args) {
        Test1();
    }
}
