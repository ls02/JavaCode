package Operation;

import Book.Book;
import Book.BookList;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-04
 * Time: 17:28
 */
public class DisplayOperation implements IOperation{
    private void menu() {
        System.out.println("============================");
        System.out.println("* 1. 查看作者相关的书籍       *");
        System.out.println("* 2. 查看所有书名            *");
        System.out.println("* 3. 查看指定类型相关的书籍   *");
        System.out.println("* 0. 返回上一级             *");
        System.out.println("============================");
    }

    private void FindAuthorBook(BookList bookList) {
        ArrayList<Book> books = bookList.Object();
        System.out.print("请输入作者名:>");
        String strAuthor = sc.nextLine();

        for (Book e : books) {
            if (e.getAuthor().equals(strAuthor)) {
                System.out.println(e);
            }
        }
    }

    private void FindTypeBook(BookList bookList) {
        ArrayList<Book> books = bookList.Object();
        System.out.print("请输入类型名:>");
        String strType = sc.nextLine();

        for (Book e : books) {
            if (e.getAuthor().equals(strType)) {
                System.out.println(e);
            }
        }
    }

    private void FindAllBook(BookList bookList) {
        ArrayList<Book> books = bookList.Object();
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("|  类型  |  书名    |作者| 价格 |");
        System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
        for (Book e : books) {
            System.out.printf("|%-4d|");
            e.Print();
        }
        System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    @Override
    public void work(BookList bookList) {
        int input = 0;

        do {
            menu();
            System.out.print("请选择:>");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    FindAuthorBook(bookList);
                    break;
                case 2:
                    FindAllBook(bookList);;
                    break;
                case 3:
                    FindTypeBook(bookList);
                    break;

                case 0:
                    break;
                default:
                    System.out.println("没有此选项!");
                    break;
            }
        } while (input != 0);
    }
}
