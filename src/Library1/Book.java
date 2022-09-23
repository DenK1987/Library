package Library1;

public class Book {
    private String bookNumber; // Номер книги в реестре
    private String bookName; // Название книги
    private String bookAuthor; // Автор книги
    private String bookGenre; // Жанр книги
    private int bookCount; // Количество книг

    public Book(String bookNumber, String bookName, String bookAuthor, String bookGenre, int bookCount) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookCount = bookCount;
    }

    public Book() {
        super();
    }

    public String getBooksInfo() {
        return String.format("  %s\t|\t%-35s |\t%-25s \t|\t%-45s\t|\t \t\t  %-5d\t\t\t|", bookNumber, bookName, bookAuthor, bookGenre, bookCount);
    }



    @Override
    public String toString() {
        return "Номер книги в реестре: " + "\"" + bookNumber + "\"" +
                "\nНазвание: " + "\"" + bookName + "\"" +
                "\nАвтор: " + "\"" + bookAuthor + "\"" +
                "\nЖанр: " + "\"" + bookGenre + "\"" +
                "\nКоличество экземпляров: " + "\"" + bookCount + "\"";
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int booksCount) {
        this.bookCount = booksCount;
    }
}