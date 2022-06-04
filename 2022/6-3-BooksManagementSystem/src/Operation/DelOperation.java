package Operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-04
 * Time: 17:07
 */
public class DelOperation implements IOperation{
    private void menu() {
        System.out.println("============================");
        System.out.println("* 1. 删除所有               *");
        System.out.println("* 2. 删除一个               *");
        System.out.println("* 0. 返回上一级             *");
        System.out.println("============================");
    }

    private void menuDele() {
        System.out.println("============================");
        System.out.println("* 1. 按书名删除             *");
        System.out.println("* 2. 按数字删除             *");
        System.out.println("* 0. 返回上一级             *");
        System.out.println("============================");
    }

    private void DeleName(BookList bookList) {
        System.out.print("请输入书名:>");
        String name = sc.nextLine();

        for (Book e : bookList.Object()) {
            if (e.getName().equals(name)) {
                e.setName(name);
                System.out.println("修改成功！");
                break;
            }
        }
    }

    private void DeleNum(BookList bookList) {
        System.out.print("请输入数字:>");
        int num = sc.nextInt();
        sc.nextLine();

        bookList.Erase(num);
        System.out.println("删除成功！");
    }

    private void SelectDele(BookList bookList) {
        int input = 0;
        do {
            menuDele();
            System.out.print("请选择:>");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    DeleName(bookList);
                    break;
                case 2:
                    DeleNum(bookList);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("没有此选项！");
                    break;
            }
        } while (input != 0);
    }
    public void work(BookList bookList) {
        int input = 0;
        do {
            menu();
            System.out.print("请选择:>");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    if (bookList.Empty()) {
                        bookList.Clear();
                        System.out.println("全部删除！\n");
                    } else {
                        System.out.println("当前书库已为空！\n");
                    }
                    break;
                case 2:
                    SelectDele(bookList);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("没有此选项！");
                    break;
            }
        } while (input != 0);
    }
}
