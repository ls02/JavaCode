/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-01
 * Time: 13:18
 */

class SListNode {
    int _val;
    SListNode _next;

    public SListNode(int val) {
        _val = val;
        _next = null;
    }
}
public class SList {
    SListNode _head;

    public SList() {
        _head = null;
    }

    public void PushBack(int val) {
//        if (_head == null) {
//            _head = new SListNode(val);
//
//            return;
//        }
//
//        SListNode cur = _head;
//        while (cur._next != null) {
//            cur = cur._next;
//        }
//
//        cur._next = new SListNode(val);
        Insert(Size(), val);
    }

    public void PushFront(int val) {
//        if (_head == null) {
//            _head = new SListNode(val);
//
//            return;
//        }
//
//        SListNode newNode = new SListNode(val);
//        newNode._next = _head;
//        _head = newNode;
//
//        return;
        Insert(0, val);
    }

    public void Insert(int pos, int val) {
        if (pos < 0 || pos > Size()) {
            System.out.println("插入位置非法!");

            return;
        }

        if (null == _head) {
            _head = new SListNode(val);
            return;
        }

        //头插
        if (0 == pos) {
            SListNode newNode = new SListNode(val);

            newNode._next = _head;
            _head = newNode;
        }
        else { //中间或尾部插
            SListNode cur = _head;
            SListNode prev = null;

            while (0 < pos) {
                prev = cur;
                cur = cur._next;
                pos--;
            }

            SListNode newNode = new SListNode(val);
            prev._next = newNode;
            newNode._next = cur;
        }
    }

    public void PopBack() {
        if (null == _head) {
            return;
        }

        SListNode cur = _head;
        SListNode prev = null;
        while (null != cur._next) {
            prev = cur;
            cur = cur._next;
        }

        if (null != prev) {
            prev._next = null;
        }
        else {
            _head = null;
        }
    }

    public void PopFront() {
        if (null == _head) {
            return;
        }

        _head = _head._next;
    }

    public void Erase(int pos) {
        if (pos < 0 || pos >= Size()) {
            System.out.println("删除位置非法!");

            return;
        }

        if (null == _head) {
            return;
        }

        //头删
        if (0 == pos) {
            _head = _head._next;
        } else {
            SListNode cur = _head;
            SListNode prev = null;

            while (0 < pos) {
                prev = cur;
                cur = cur._next;
                --pos;
            }

            prev._next = cur._next;
        }
    }

    public SListNode Find(int key) {
        SListNode cur = _head;

        while (null != cur) {
            if (cur._val == key) {
                return cur;
            }

            cur = cur._next;
        }

        return null;
    }

    public void Display() {
        SListNode cur = _head;

        while (cur != null) {
            System.out.print(cur._val + " ");
            cur = cur._next;
        }

        System.out.println();
    }

    public int Size() {
        SListNode cur = _head;
        int count = 0;
        while (null != cur) {
            count++;
            cur = cur._next;
        }

        return count;
    }
}
