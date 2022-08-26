package Library1;


import java.util.List;
import java.util.Scanner;

public class Library {
    public BookRegister bookRegister = new BookRegister();
    public UserBase userBase = new UserBase();
    List<User> userList = userBase.UserList();
    List<Book> bookList = bookRegister.getAllList();
    Book book = new Book();
    Admin admin = new Admin("admin", "admin");
    Scanner sc = new Scanner(System.in);


    public User getUserbyId(String adid) {
        for (int i = 0; i < userList.size(); i++) {
            User admtemp = userList.get(i);
            if (admtemp.getUserLogin().equals(adid)) {
                return admtemp;
            }
        }
        return null;
    }

    /**
     * Показать список всех книг
     */
    public void showALLBooks() {
        int sum = 0;
        System.out.println("--------------------------------------------------------------");
        System.out.println("В библиотеке зарегистрирована коллекция из " + bookList.size() + " книг");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(" Номер\t|\t\t\t\tНазвание\t\t\t\t|\t\t\t  Автор\t\t\t\t|\t\t\t\t\t\tЖанр\t\t\t\t\t\t|\tКоличество экземпляров\t|");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < bookList.size(); i++) {
            Book bookTemp = bookList.get(i);
            System.out.println(bookTemp.getBooksInfo());
            sum += bookList.get(i).getBooksCount();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("Общее количество экземпляров всех книг: " + sum);
    }

    /**
     * Поиск книги по названию
     */
    public boolean searchForBookByName() {
        int sum = 0;
        System.out.println("--------------------------------------------------------------");
        System.out.print("Введите название книги: ");
        String bookName = sc.nextLine();
        for (int i = 0; i < bookList.size(); i++) {
            Book bookTemp = bookList.get(i);
            if (bookName.equalsIgnoreCase(bookTemp.getBookName())) {
                System.out.println("\n" + bookTemp);
            }
        }
        return false;
    }

    /**
     * Поиск книги по жанру
     */
    public boolean searchForBookByGenre() {
        System.out.println("--------------------------------------------------------------");
        System.out.print("Введите жанр: ");
        String bookGenre = sc.nextLine();
        List<Book> bookList = bookRegister.getAllList();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(" Номер\t|\t\t\t\tНазвание\t\t\t\t|\t\t\t  Автор\t\t\t\t|\t\t\t\t\t\tЖанр\t\t\t\t\t\t|\tКоличество экземпляров\t|");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < bookList.size(); i++) {
            Book bookTemp = bookList.get(i);
            if (bookGenre.equals(bookTemp.getBookGenre())) {
                System.out.println(bookTemp.getBooksInfo());
                //System.out.println("Запрос успешен!");
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        return false;
    }


    /**
     * Бизнес логика: функция входа для пользователя
     */
    public boolean checkLoginForUser(String login, String password) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (login.equals(user.getUserLogin()) && password.equals(user.getUserPassword())) {
                System.out.println("\nИнформация верна, и вы вошли в основное меню!");
                return true;
            } else {
                System.out.println("\nНеверное имя пользователя или пароль!");
            }
        }
        return false;
    }

    /**
     * Бизнес логика: функция входа для администратора
     */
    public boolean checkLoginForAdmin(String login, String password) {
        if (login.equals(admin.getAdminLogin()) && password.equals(admin.getAdminPassword())) {
            System.out.println("\nИнформация верна, и вы вошли в основное меню!");
            return true;
        } else {
            System.out.println("\nНеверное имя пользователя или пароль!");
        }
        return false;
    }


    /**
     * Запрос книг по автору
     */
    public boolean adauthor(String author) {
        for (int i = 0; i < bookList.size(); i++) {
            Book booktemp = bookList.get(i);
            if (booktemp.getBookAuthor().equals(author)) {
                System.out.println(booktemp.toString());

            }
        }
        return false;
    }


    /**
     * Добавить книги
     */
    public boolean addbook(String ISBN, String bookName, String author,
                           String genre, int bookcount) {
        Book book = new Book(ISBN, bookName, author, genre, bookcount);
        for (int i = 0; i < bookList.size(); i++) {
            Book booktemp = bookList.get(i);
            if (booktemp.getBookNumber().equals(ISBN) || booktemp.getBookName().equals(bookName)) {
                System.err.println("Книга, которую вы ввели, уже существует");
                return false;
            }
        }
        bookRegister.addBook(book);
        System.out.println("Успешно добавлено!");
        return true;

    }

    /**
     * Изменить количество модификации книги
     */
    public boolean updatecount(String ISBN, int bookcount) {
        for (int i = 0; i < bookList.size(); i++) {
            Book booktemp = bookList.get(i);
            if (booktemp.getBookNumber().equals(ISBN)) {
                booktemp.setBooksCount(bookcount);
                System.out.println("Изменено успешно");
            }
        }
        return false;
    }

    /**
     * Удалить книги
     */
    public boolean deletebook(String ISBN) {
        for (int i = 0; i < bookList.size(); i++) {
            Book booktemp = bookList.get(i);
            if (booktemp.getBookNumber().equals(ISBN)) {
                bookList.remove(i);
                System.out.println("Успешно удалено");
            } else {
                System.err.println("Номер книги, которую вы хотите удалить, не найден!");
                return true;
            }
        }
        return false;
    }

    /**
     * Регистрация
     *
     * @return
     */
    public void userRegistration(String login, String password) {
        User user = new User(userList.size(), login, password);
        userBase.insert(user);
        System.out.println("\nРегистрация прошла успешна!");
    }


}
