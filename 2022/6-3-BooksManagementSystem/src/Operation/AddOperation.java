package Operation;

import Book.Book;
import Book.BookList;
import com.sun.deploy.net.MessageHeader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-04
 * Time: 17:07
 */
public class AddOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书！");
        System.out.print("请输入书名:>");
        String name = sc.nextLine();
        System.out.print("请输入作者名:>");
        String author = sc.nextLine();
        System.out.print("请输入书的类型:>");
        String type = sc.nextLine();
        System.out.print("请输入价格:>");
        String priceStr = sc.nextLine();
        int price = Integer.parseInt(priceStr);

        Book book = new Book(name, type, price, author);
        bookList.AddBook(book);
    }
}
