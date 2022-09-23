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

    /**
     * Показать список всех пользователей
     */
    public void showAllUsers() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Список всех зарегистрированных пользователей\n");
        System.out.println("----------------------------------------------------------------|");
        System.out.println("Номер регистрации |\t\tИмя пользователя\t|\t\tПароль\t\t|");
        System.out.println("----------------------------------------------------------------|");
        for (int i = 0; i < userList.size(); i++) {
            User userTemp = userList.get(i);
            System.out.println(userTemp.getUsersInfo());
        }
        System.out.println("----------------------------------------------------------------|");
        System.out.println("В библиотеке зарегистрировано пользователей: " + userList.size());
    }

    /**
     * Показать список всех книг
     */
    public void showAllBooks() {
        int sum = 0;
        System.out.println("--------------------------------------------------------------");
        System.out.println("Список всех книг\n");
        System.out.println("В библиотеке зарегистрирована коллекция из " + bookList.size() + " книг");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(" Номер\t|\t\t\t\tНазвание\t\t\t\t|\t\t\t  Автор\t\t\t\t|\t\t\t\t\t\tЖанр\t\t\t\t\t\t|\tКоличество экземпляров\t|");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < bookList.size(); i++) {
            Book bookTemp = bookList.get(i);
            System.out.println(bookTemp.getBooksInfo());
            sum += bookList.get(i).getBookCount();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("Общее количество экземпляров всех книг: " + sum);
    }

    /**
     * Поиск книги по названию
     */
    public void searchForBookByName() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Поиск книги по названию\n");
        System.out.print("Введите название книги: ");
        String bookName = sc.nextLine();
        for (int i = 0; i < bookList.size(); i++) {
            Book bookTemp = bookList.get(i);
            if (bookName.equalsIgnoreCase(bookTemp.getBookName())) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                System.out.println(" Номер\t|\t\t\t\tНазвание\t\t\t\t|\t\t\t  Автор\t\t\t\t|\t\t\t\t\t\tЖанр\t\t\t\t\t\t|\tКоличество экземпляров\t|");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                System.out.println(bookTemp.getBooksInfo());
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                return;
            }
        }
        System.err.println("Книга не найдена!");

    }

    /**
     * Поиск книги по жанру
     */
    public void searchForBookByGenre() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Поиск книги по жанру\n");
        System.out.print("Введите жанр: ");
        String bookGenre = sc.nextLine();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(" Номер\t|\t\t\t\tНазвание\t\t\t\t|\t\t\t  Автор\t\t\t\t|\t\t\t\t\t\tЖанр\t\t\t\t\t\t|\tКоличество экземпляров\t|");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        int count = 0;
        for (int i = 0; i < bookList.size(); i++) {
            Book bookTemp = bookList.get(i);
            if (bookGenre.equalsIgnoreCase(bookTemp.getBookGenre())) {
                System.out.println(bookTemp.getBooksInfo());
                count++;
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("Найдено книг в количестве: " + count);
    }

    /**
     * Поиск книги по автору
     */
    public void searchForBookByAuthor() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Поиск книги по автору\n");
        System.out.print("Введите автора: ");
        String bookAuthor = sc.nextLine();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(" Номер\t|\t\t\t\tНазвание\t\t\t\t|\t\t\t  Автор\t\t\t\t|\t\t\t\t\t\tЖанр\t\t\t\t\t\t|\tКоличество экземпляров\t|");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        int count = 0;
        for (int i = 0; i < bookList.size(); i++) {
            Book bookTemp = bookList.get(i);
            if (bookAuthor.equalsIgnoreCase(bookTemp.getBookAuthor())) {
                System.out.println(bookTemp.getBooksInfo());
                count++;
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("Найдено книг в количестве: " + count);
    }

//    /**
//     * Взять книги для чтения
//     */
//    public void takeBooksToRead(User user) {
//        System.out.println("--------------------------------------------------------------");
//        System.out.println("Взять книги для чтения\n");
//        System.out.print("Введите название книги или автора: ");
//        String nameBookOrAuthor = sc.next();
//        //System.out.print("Введите номер книги, которая будет изменена: ");
//        //String bookNumber = sc.next();
//        System.out.print("Введите количество экземпляров книги, которые хотите взять для чтения: ");
//        int bookCount = sc.nextInt();
//        for (int i = 0; i < bookList.size(); i++) {
//            Book bookTemp = bookList.get(i);
//            if (nameBookOrAuthor.equalsIgnoreCase(bookTemp.getBookName()) || nameBookOrAuthor.equalsIgnoreCase(bookTemp.getBookAuthor())) {
//                int i1 = bookTemp.getBookCount() - bookCount;
//                System.out.println("\nКоличество экземпляров изменено успешно!");
//            }
//        }
//    }


    /**
     * Добавить новые книги
     */
    public void addBook() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Добавить книгу\n");
        System.out.print("Введите номер в реестре для добавления книги: ");
        String bookNumber = sc.next();
        System.out.print("Введите название книги: ");
        String bookName = sc.next();
        System.out.print("Введите автора книги: ");
        String bookAuthor = sc.next();
        System.out.print("Введите жанр книги: ");
        String bookGenre = sc.next();
        System.out.print("Введите количество экземпляров добавляемой книги: ");
        int bookCount;
        while (!sc.hasNextInt()) {
            System.err.println("ОШИБКА! Некорректный ввод!");
            System.out.print("\nВведите количество экземпляров добавляемой книги: ");
            sc.next();
        }
        bookCount = sc.nextInt();
        Book book = new Book(bookNumber, bookName, bookAuthor, bookGenre, bookCount);
        for (int i = 0; i < bookList.size(); i++) {
            Book bookTemp = bookList.get(i);
            if (bookNumber.equals(bookTemp.getBookNumber()) || bookName.equalsIgnoreCase(bookTemp.getBookName())) {
                System.err.println("Номер или название книги, которую вы ввели, уже существует!");
                return;
            }
        }
        bookRegister.addBook(book);
        System.out.println("\nКнига успешно добавлена!");
    }

    /**
     * Изменить количество экземпляров книги
     */
    public void changeCountCopiesBook() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Изменить количество экземпляров книги\n");
        System.out.print("Введите номер книги, которая будет изменена: ");
        String bookNumber = sc.next();
        System.out.print("Введите количество экземпляров книги, которые будут изменены: ");
        int bookCount = sc.nextInt();
        for (int i = 0; i < bookList.size(); i++) {
            Book bookTemp = bookList.get(i);
            if (bookNumber.equals(bookTemp.getBookNumber())) {
                bookTemp.setBookCount(bookCount);
                System.out.println("\nКоличество экземпляров изменено успешно!");
            }
        }
    }

    /**
     * Удалить книги
     */
    public void deleteBook() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Удалить книгу\n");
        System.out.print("Введите номер книги для удаления: ");
        String bookNumber = sc.next();
        for (int i = 0; i < bookList.size(); i++) {
            Book bookTemp = bookList.get(i);
            if (bookNumber.equals(bookTemp.getBookNumber())) {
                bookList.remove(i);
                System.out.println("\nКнига успешно удалена!");
                return;
            }
        }
        System.err.println("Номер книги, которую вы хотите удалить, не найден!");

//        Iterator<Book> bookIterator = bookList.iterator();
//        while(bookIterator.hasNext()) {
//            Book nextBook = bookIterator.next();
//            if (nextBook.getBookNumber().equals(bookNumber)) {
//                bookIterator.remove();
//                System.out.println("\nКнига успешно удалена!");
//                return;
//            }
//        }
//        System.err.println("Номер книги, которую вы хотите удалить, не найден!");
//
    }

    /**
     * Метод входа для администратора
     */
    public boolean checkLoginForAdmin(String login, String password) {
        if (login.equals(admin.getAdminLogin()) && password.equals(admin.getAdminPassword())) {
            System.out.println("\nИнформация верна, и вы вошли в основное меню!");
            return true;
        }
        System.err.println("Неверное имя пользователя или пароль!");
        return false;
    }

    /**
     * Метод входа для пользователя
     */
    public boolean checkLoginForUser(String login, String password) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (login.equals(user.getUserLogin()) && password.equals(user.getUserPassword())) {
                System.out.println("\nИнформация верна, и вы вошли в основное меню!");
                return true;
            }
        }
        System.err.println("Неверное имя пользователя или пароль!");
        return false;
    }


    /**
     * Регистрация пользователя
     */
    public void userRegistration(String login, String password) {
        User user = new User(userList.size(), login, password);
        for (int i = 0; i < userList.size(); i++) {
            User userTemp = userList.get(i);
            if (login.equals(userTemp.getUserLogin())) {
                System.err.println("Пользователь с данным именем уже существует!");
                return;
            }
        }
        userBase.insert(user);
        System.out.println("\nРегистрация прошла успешна!");
    }


}
