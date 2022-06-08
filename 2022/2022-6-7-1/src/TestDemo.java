import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-07
 * Time: 22:02
 * @author 86176
 */
public class TestDemo {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();

        s1.add(1);
        s1.add(2);
        s1.add(3);

        for (int e : s1) {
            System.out.println(e);
        }

        System.out.println(s1);
    }
}
