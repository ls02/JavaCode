/**
 * Created with IntelliJ IDEA.
 * Description:顺序表
 * User: 86176
 * Date: 2022-05-31
 * Time: 17:38
 */
public class SeqList {
    private int[] _data;
    private int _size;
    private int _capacity;

    /**
     * 构造方法
     * @param capacity 容量
     */
    public SeqList(int capacity) {
        _data = new int[capacity];
        _size = 0;
        _capacity = capacity;
    }

    /**
     * 默认构造
     */
    public SeqList() {
        _data = new int[4];
        _size = 0;
        _capacity = 4;
    }

    /**
     * 拷贝构造
     * @param seqL 传递一个对象
     */
    public SeqList(SeqList seqL) {
        _data = new int[seqL.Size()];

        for (int i = 0; i < seqL._size; i++) {
            _data[i] = seqL._data[i];
        }

        _size = seqL.Size();
        _capacity = seqL._capacity;
    }

    /**
     * 获取顺序表大小
     * @return 返回顺序表当前实际存放的有效元素个数
     */
    public int Size() {
        return _size;
    }

    /**
     * 尾插数据
     * @param val 插入的值
     */
    public void PushBack(int val) {
        CheckCapacity();

        _data[_size] = val;
        _size++;
    }

    /**
     * pos位置插入
     * @param pos 要插入的位置
     * @param val 插入的数据
     */
    public void Insert(int pos, int val) {
        if (pos < 0 || pos > _capacity) {
            System.out.println("插入位置非法！");

            return;
        }

        CheckCapacity();

        for (int i = _size; i >= pos; i--) {
            _data[i + 1] = _data[i];
        }

        _data[pos] = val;
        _size++;
    }

    /**
     * 尾删一个数据
     */
    public void PopBack() {
        if (_size == 0) {
            return;
        }

        _size--;
    }

    /**
     * 删除pos位置的数据
     * @param pos 要删除的位置
     */
    public void Erase(int pos) {
        if (pos < 0 || pos > _capacity) {
            System.out.println("删除位置非法");

            return;
        }

        if (_size == 0) {
            return;
        }

        for (int i = pos + 1; i < _size; i++) {
            _data[i - 1] = _data[i];
        }

        _size--;
    }

    /**
     * 检查是否需要扩容
     */
    private void CheckCapacity() {
        if (_size == _capacity) {
            int[] newData = new int[_capacity * 2];

            for (int i = 0; i < _size; i++) {
                newData[i] = _data[i];
            }

            _data = newData;
            _capacity *= 2;
        }
    }

    /**
     * 拷贝数据
     * @param copy 要拷贝的对象
     */
    public void CopyOfArr(int[] copy) {
        _data = new int[copy.length];
        for (int i = 0; i < _size; i++) {
            _data[i] = copy[i];
        }

        _size = copy.length;
    }

    /**
     * 显示顺序表内的数据
     */
    public void Display() {
        for (int i = 0; i < _size; i++) {
            System.out.print(_data[i] + " ");
        }

        System.out.println();
    }

    /**
     * 查找一个值是否在顺序表内
     * @param key 要查找的值
     * @return 返回找到的值的下标
     */
    public int Find(int key) {
        for (int i = 0; i < _size; i++) {
            if (_data[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public void Clear() {
        _size = 0;
    }

}
