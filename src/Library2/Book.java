package Library2;

public class Book {
    private String ISBN;      // Номер книги
    private String bookName;  // Название книги
    private String author;    // Автор
    private int pagenum;      // Общее количество страниц
    private String publisher; // Нажмите
    private int bookcount;    // Количество книг


    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPagenum() {
        return pagenum;
    }
    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getBookcount() {
        return bookcount;
    }
    public void setBookcount(int bookcount) {
        this.bookcount = bookcount;
    }

    @Override
    public String toString() {
        return "Книга [Номер книги =" + ISBN + ", Название книги =" + bookName + ", Автор ="
                + author + "Всего страниц =" + pagenum + "Издатель =" + publisher
                + "Количество книг =" + bookcount;
    }

    public Book(String iSBN, String bookName, String author, int pagenum,
                String publisher, int bookcount) {
        super();
        ISBN = iSBN;
        this.bookName = bookName;
        this.author = author;
        this.pagenum = pagenum;
        this.publisher = publisher;
        this.bookcount = bookcount;
    }

    public Book() {
        super();
    }
}
