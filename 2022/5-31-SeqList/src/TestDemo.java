/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-05-31
 * Time: 17:38
 */
public class TestDemo {
    public static void main(String[] args) {
        SeqList s1 = new SeqList();

        s1.PushBack(1);
        s1.PushBack(2);
        s1.PushBack(3);
        s1.PushBack(4);
        s1.PushBack(5);
        s1.PushBack(6);
        s1.PushBack(7);

        SeqList s2 = new SeqList(s1);
        SeqList s3 = new SeqList(s1);

        s1.Display();
        s2.Display();

        System.out.println(s1.Size());

        s1.Erase(0);
        s1.Erase(0);
        s1.Erase(0);
        s1.Erase(0);
        s1.Erase(0);
        s1.Erase(0);
        s1.Erase(0);
        s1.Erase(0);
        s1.Erase(0);

        s1.Insert(0, 1);
        s1.Insert(0, 2);
        s1.Insert(0, 3);
        s1.Insert(0, 4);
        s1.Insert(0, 5);

        s1.PopBack();

        s1.Display();
        System.out.println(s1.Size());

        s1.PopBack();
        s1.PopBack();
        s1.PopBack();
        s1.PopBack();
        s1.PopBack();
        System.out.println(s1.Size());

        int ret = s3.Find(3);
        System.out.println(ret);
    }
}
