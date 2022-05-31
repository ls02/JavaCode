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
        _data = new int[10];
        _size = 0;
        _capacity = 10;
    }

    /**
     * 拷贝构造
     * @param sqeL 传递一个对象
     */
    public SeqList(SeqList sqeL) {
        _data = new int[sqeL._size];

        for (int i = 0; i < sqeL._size; i++) {
            _data[i] = seqL._data[i];
        }
    }

    /**
     * 获取顺序表大小
     * @return 返回顺序表当前实际存放的有效元素个数
     */
    public int Size() {
        return _size;
    }


}
