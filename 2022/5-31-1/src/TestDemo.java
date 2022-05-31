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

    static void SwapArray(int[] arr1, int[] arr2) {
        int len = arr1.length;

        if (len > arr2.length) {
            len = arr2.length;
        }

        for (int i = 0; i < len; i++) {
            int temp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = temp;
        }

    }

    static void Test2() {
        int[] arr1 = { 1, 2, 3, 4 };
        int[] arr2 = { 4, 3, 2, 1 };

        SwapArray(arr1, arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void main(String[] args) {
        Test2();
//        Test1();
    }
}
