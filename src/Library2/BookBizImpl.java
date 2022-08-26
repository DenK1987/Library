package Library2;

import java.util.List;


public class BookBizImpl {

    public BookDaoImpl bdi = new BookDaoImpl();
    public AdminDaoImpl adi = new AdminDaoImpl();
    List<Admin> admList = adi.AdminList();
    List<Book> booklist = bdi.getAllList();
    Book book=new Book();


    public Admin getAdminbyId(String adid) {
        for (int i = 0; i < admList.size(); i++) {
            Admin admtemp = admList.get(i);
            if (admtemp.getAdid().equals(adid)) {
                return admtemp;
            }
        }
        return null;
    }
    /**
     * Запрос всех книг
     */
    public void showALLBook() {
        int sum=0;
        System.out.println("Эта библиотека является общей"+booklist.size()+"Посадочная книга");
        for (int i = 0; i < booklist.size(); i++) {
            Book booktemp = booklist.get(i);
            System.out.println(booktemp.toString());
            sum +=booklist.get(i).getBookcount();   // Получить общее количество всех книг в библиотеке
        }
        System.out.println("Библиотека Общая коллекция:"+sum);  // Распечатать всю коллекцию библиотеки
    }
    /**
     * Бизнес логика: функция входа
     */
    public boolean Admin(String adid, String adpwd) {
        for (int i = 0; i < admList.size(); i++) {
            Admin adtemp = admList.get(i);
            if (adid.equals(adtemp.getAdid())
                    && adpwd.equals(adtemp.getAdpwd())) {
                System.out.println("Информация верна, и вы вошли в систему!");
                return true;
            }else{
                System.err.println("Неверное имя пользователя или пароль!");
            }
        }
        return false;
    }
    /**
     * Запрос книг по автору
     */
    public boolean adauthor(String author) {
        for (int i = 0; i <booklist.size(); i++) {
            Book booktemp=booklist.get(i);
            if(booktemp.getAuthor().equals(author)){
                System.out.println(booktemp.toString());

            }
        }
        return false;
    }

    /**
     * Запрос книг по издателям
     */
    public boolean adpublisher(String publisher) {
        List<Book> booklist = bdi.getAllList();
        for (int i = 0; i <booklist.size(); i++) {
            Book booktemp=booklist.get(i);
            if(publisher.equals(booktemp.getPublisher())){
                System.out.println(booktemp.toString());
                System.out.println("Запрос успешен!");
            }
        }
        return false;
    }
    /**
     * Найти книги на основе названий
     */
    public boolean adbookname(String bookname){

        for (int i = 0; i <booklist.size(); i++) {
            Book booktemp=booklist.get(i);
            if(booktemp.getBookName().equals(bookname)){
                System.out.println(booktemp.toString());
            }
        }
        return false;
    }
    /**
     * Добавить книги
     */
    public boolean addbook(String ISBN, String bookName, String author,
                           int pagenum, String publisher, int bookcount) {
        Book book=new Book(ISBN, bookName, author, pagenum, publisher, bookcount);
        for (int i = 0; i < booklist.size(); i++) {
            Book booktemp=booklist.get(i);
            if (booktemp.getISBN().equals(ISBN) || booktemp.getBookName().equals(bookName)){
                System.err.println("Книга, которую вы ввели, уже существует");
                return false;
            }
        }
        bdi.addbook(book);
        System.out.println("Успешно добавлено!");
        return true;

    }
    /**
     * Изменить количество модификации книги
     */
    public boolean updatecount(String ISBN, int bookcount) {
        for (int i = 0; i <booklist.size(); i++) {
            Book booktemp=booklist.get(i);
            if(booktemp.getISBN().equals(ISBN)){
                booktemp.setBookcount(bookcount);
                System.out.println("Изменено успешно");
            }
        }
        return false;
    }
    /**
     * Удалить книги
     */
    public boolean deletebook(String ISBN) {
        for (int i = 0; i <booklist.size(); i++) {
            Book booktemp=booklist.get(i);
            if(booktemp.getISBN().equals(ISBN)){
                booklist.remove(i);
                System.out.println("Успешно удалено");
            }else{
                System.err.println("Номер книги, которую вы хотите удалить, не найден!");
                return true;
            }
        }
        return false;
    }
    /**
     * Регистрация
     */
    public void regist(String adid, String adpwd) {
        Admin admin = new Admin(admList.size() + 1, adid, adpwd);
        adi.insert(admin);
    }
}