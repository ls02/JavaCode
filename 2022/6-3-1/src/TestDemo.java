import java.util.Collection;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-03
 * Time: 18:40
 */
public class TestDemo {

    static void Test1() {
        Collection<String> co = new ArrayList<>();
        co.add("hello");

        System.out.println(co);
    }

    public static void main(String[] args) {
        Test1();
    }
}
