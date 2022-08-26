//import java.util.Scanner;
public class Book extends Books{
// library;

    public int    sNo;
    public String bookName;
    public String authorName;
    public int    bookQty;
    public int    bookQtyCopy;

    public Book(int no, String title, String author, int quantity) {
        sNo         = no;
        bookName    = title;
        authorName  = author;
        bookQty     = quantity;
        bookQtyCopy = bookQty;
    }
    public Book(){

        System.out.println("\r\n" + "Введите серийный номер книги:");
        this.sNo = input.nextInt();
        input.nextLine();
        System.out.println("Введите название книги:");
        this.bookName = input.nextLine();
        System.out.println("Введите имя автора книги:");
        this.authorName = input.nextLine();
        System.out.println("Введите количество книг:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;

    }
}