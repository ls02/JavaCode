/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-01
 * Time: 13:17
 */
public class TestDemo {

    static void SListTest1() {
        SList l1 = new SList();
        l1.PushBack(1);
        l1.PushBack(2);
        l1.PushBack(3);
        l1.PushBack(4);
        l1.PushFront(5);
        l1.PushFront(6);
        l1.PushFront(7);

        l1.Display();

        l1.PopBack();
        l1.PopBack();
        l1.PopBack();
        l1.PopBack();
        l1.PopBack();
        l1.PopBack();
        l1.PopBack();
        l1.PopBack();
        l1.Display();

        l1.PushFront(6);
        l1.PushFront(7);
        l1.PushFront(8);
        l1.PushFront(9);

        l1.Display();

        l1.PopFront();
        l1.PopFront();
        l1.PopFront();
        l1.PopFront();
        l1.PopFront();
        l1.Display();

        l1.Insert(0, 1);
//        l1.PushBack(2);
        l1.Insert(0, 2);
        l1.Insert(0, 3);
        l1.Insert(0, 4);
        l1.Display();

        l1.Insert(1, 20);
        l1.Insert(5, 200);
        l1.Display();
        System.out.println(l1.Size());

        l1.Erase(6);

        l1.Display();

        SListNode temp = l1.Find(300);
        if (null != temp) {
            System.out.println(temp._val);
        } else {
            System.out.println("没找到!");
        }
    }

    public static void ListTest1() {
        List l1 = new List();

//        l1.Insert(0, 1);
//        l1.Insert(0, 2);
        l1.PushBack(1);
        l1.PushBack(2);
        l1.PushBack(3);
        l1.PushBack(4);

        l1.PushFront(5);
        l1.PushFront(6);
        l1.PushFront(7);


        l1.Display();

        l1.PopFront();
        l1.PopFront();
        l1.Display();

        l1.Erase(0);
        l1.Display();

        ListNode temp = l1.Find(1);

        if (null != temp) {
            System.out.println("找到了");
        } else {
            System.out.println("没找到");
        }
    }

    public static void main(String[] args) {
        ListTest1();
//        SListTest1();
    }
}
