import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-05-31
 * Time: 10:52
 */
public class TestDemo {

    static void Test1() {
        int[] arr = { 4, 2, 3, 1 };

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (left < right && arr[left] % 2 != 0) {
                left++;
            }

            while (left < right && arr[right] % 2 == 0) {
                right--;
            }

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            ++left;
            --right;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Test1();
    }
}
