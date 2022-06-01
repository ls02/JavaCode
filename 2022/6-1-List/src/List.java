/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-01
 * Time: 13:18
 */
class ListNode {
    public int _val;
    public ListNode _prev;
    public ListNode _next;

    public ListNode(int val) {
        _val = val;
    }
}
public class List {
    private ListNode _head;

    public List() {
        _head = new ListNode(-1);

        _head._next = _head;
        _head._prev = _head;
    }

    public void PushBack(int val) {
        Insert(Size(), val);
    }

    public void PushFront(int val) {
        Insert(0, val);
    }

    public void Insert(int pos, int val) {
        if (pos < 0 || pos > Size()) {
            System.out.println("插入位置非法");

            return;
        }

        if (_head._next == _head) {
            ListNode newNode = new ListNode(val);
            _head._next = newNode;
            _head._prev = newNode;

            newNode._prev = _head;
            newNode._next = _head;

            return;
        }

        if (pos == 0) {
            ListNode newNode = new ListNode(val);
            ListNode next = _head._next;

            newNode._next = next;
            next._prev = newNode;
            newNode._prev = _head;
            _head._next = newNode;
        } else {
            ListNode cur = _head._next;;
            ListNode prev = null;

            while (pos > 0) {
                prev = cur;
                cur = cur._next;

                pos--;
            }

            ListNode newNode = new ListNode(val);
            newNode._next = cur;
            newNode._prev = prev;
            prev._next = newNode;
            cur._prev = newNode;
        }
    }

    public void PopBack() {
        Erase(Size() - 1);
    }

    public void PopFront() {
        Erase(0);
    }

    public void Erase(int pos) {
        ListNode cur = _head._next;
        if (_head == cur) {
            return;
        }

        if (pos < 0 || pos >= Size()) {
            System.out.println("删除位置非法!");

            return;
        }


        if (pos == 0) {
            ListNode next = cur._next;
            _head._next = next;
            next._prev = _head;

            cur = null;
        } else {
            ListNode prev = null;
            while (pos > 0) {
                prev = cur;
                cur = cur._next;
                pos--;
            }

            ListNode next = cur._next;
            prev._next = next;
            next._prev = prev;

            cur = null;
        }
    }

    public void Display() {
        ListNode cur = _head._next;

        while (_head != cur) {
            System.out.print(cur._val + " ");
            cur = cur._next;
        }

        System.out.println();
    }

    public int Size() {
        ListNode cur = _head._next;
        int count = 0;

        while (_head != cur) {
            count++;
            cur = cur._next;;
        }

        return count;
    }

    public ListNode Find(int key) {
        ListNode cur = _head._next;

        while (cur != _head) {
            if (cur._val == key) {
                return cur;
            }

            cur = cur._next;
        }

        return null;
    }
}
