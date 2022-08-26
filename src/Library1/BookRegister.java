package Library1;


import java.util.ArrayList;
import java.util.List;

public class BookRegister implements Registrable {
    List<Book> bookList = new ArrayList<>();

    public void initBooks() {
        Book book1 = new Book("001", "451° по Фаренгейту", "Рэй Брэдбери", "научно-фантастический роман-антиутопия",10);
        Book book2 = new Book("002", "Евгений Онегин", "Александр Пушкин", "роман", 10);
        Book book3 = new Book("003", "Код да Винчи", "Дэн Браун", "триллер, детектив", 10);
        Book book4 = new Book("004", "1984", "Джордж Оруэлл", "роман-антиутопия", 10);
        Book book5 = new Book("005", "Война и мир", "Лев Толстой", "роман-эпопея", 10);
        Book book6 = new Book("006", "Мастер и Маргарита", "Михаил Булгаков", "роман", 10);
        Book book7 = new Book("007", "Шантарам", "Грегори Дэвид Робертс", "роман", 10);
        Book book8 = new Book("008", "Три товарища", "Эрих Мария Ремарк", "роман", 10);
        Book book9 = new Book("009", "Портрет Дориана Грея", "Оскар Уайльд", "роман", 10);
        Book book10 = new Book("010", "Цветы для Элджернона", "Дэниел Киз", "научно-фантастический рассказ", 10);
        Book book11 = new Book("011", "Маленький принц", "Антуан де Сент-Экзюпери", "аллегорическая повесть-сказка", 10);
        Book book12 = new Book("012", "Над пропастью во ржи", "Джером Д. Сэлинджер", "роман", 10);
        Book book13 = new Book("013", "Вино из одуванчиков", "Рэй Брэдбери", "повесть", 10);
        Book book14 = new Book("014", "Атлант расправил плечи", "Айн Рэнд", "роман-антиутопия", 10);
        Book book15 = new Book("015", "Анна Каренина", "Лев Толстой", "роман", 10);
        Book book16 = new Book("016", "Убить пересмешника", "Харпер Ли", "роман-бестселлер", 10);
        Book book17 = new Book("017", "Преступление и наказание", "Фёдор Достоевский", "соц.-психологический и соц.-философский роман", 10);
        Book book18 = new Book("018", "Граф Монте-Кристо", "Александр Дюма", "приключенческий роман", 10);
        Book book19 = new Book("019", "Великий Гэтсби", "Фрэнсис Скотт Фицджеральд", "роман", 10);
        Book book20 = new Book("020", "Гарри Поттер и философский камень", "Джоан К. Роулинг", "фэнтези", 10);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        bookList.add(book9);
        bookList.add(book10);
        bookList.add(book11);
        bookList.add(book12);
        bookList.add(book13);
        bookList.add(book14);
        bookList.add(book15);
        bookList.add(book16);
        bookList.add(book17);
        bookList.add(book18);
        bookList.add(book19);
        bookList.add(book20);
    }

    @Override
    public List<Book> getAllList() {
        return bookList;
    }

    @Override
    public boolean addBook(Book book) {
        return bookList.add(book);
    }

    @Override
    public boolean deleteBook(Book book) {
        return false;
    }

    @Override
    public boolean updateBooks(Book book) {
        return false;
    }

}