package Book;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-04
 * Time: 14:20
 */
public class BookList {
    private ArrayList<Book> books = new ArrayList<>();

    public int GetSize(){
        return this.books.size();
    }

    public Book GetPos(int pos) {
        return this.books.get(pos);
    }

    public void AddBook(Book book) {
        this.books.add(book);
    }

    public void Clear() {
        this.books.clear();
    }

    public boolean Empty() {
        return books.isEmpty();
    }

    public ArrayList<Book> Object() {
        return this.books;
    }

    public void Erase(int pos) {
        books.remove(pos);
    }
}
