package Operation;

import Book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-04
 * Time: 17:30
 */
public interface IOperation {
    Scanner sc = new Scanner(System.in);

    void work(BookList bookList);
}
