package User;

import Book.BookList;
import Operation.IOperation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-05
 * Time: 16:57
 */
public abstract class User {
    protected Strin g name;
    protected IOperation[] iOperation;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doWork(int choice, BookList bookList) {
        iOperation[choice].work(bookList);
    }
}
