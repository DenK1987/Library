package Library2;

import java.util.Scanner;


public class BookMenu {
    Scanner input = new Scanner(System.in);
    BookBizImpl bookimpl = new BookBizImpl();
    Admin admtemp = null;

    public BookMenu() {
        bookimpl.bdi.init();
        bookimpl.adi.init();
    }

    /**
     * Метод входа в меню
     */
    public void showMenu() {
        while (true) {
            System.out.println("------ Добро пожаловать в систему управления библиотекой --------");
            System.out.println("-----------------------------");
            System.out.println("1. логин");
            System.out.println("2. Регистрация");
            System.out.println("3. Выход из меню");
            int search = input.nextInt();
            switch (search) {
                case 1:// Войти
                    System.out.println("Пожалуйста, введите учетную запись администратора и пароль:");
                    System.out.println("Пожалуйста, введите ваше имя пользователя:");
                    String adid = input.next();
                    System.out.println("Пожалуйста, введите пароль:");
                    String adpwd = input.next();
                    boolean isloginsuceess = bookimpl.Admin(adid, adpwd);
                    if (isloginsuceess == true) {
                        showLoginMenu();
                    }
                    continue;
                case 2:// зарегистрироваться
                    System.out.println("Регистрация");
                    System.out.println("Пожалуйста, введите ваше имя пользователя:");
                    String username1 = input.next();
                    System.out.println("Пожалуйста, введите пароль:");
                    String password1 = input.next();
                    bookimpl.regist(username1, password1);
                    continue;
                case 3:// выход
                    System.out.println("----- Добро пожаловать в следующий раз! ------");
                    System.exit(1);
                    continue;
                default:
                    showMenu();
                    break;
            }
        }
    }

    /**
     * Фоновая операция после успешного входа
     */
    public void showLoginMenu() {
        while (true) {
            System.out.println("------ Добро пожаловать в систему управления библиотекой --------");
            System.out.println("-----------------------------");
            System.out.println("1. Запросить все книги");
            System.out.println("2. Запрос книг по автору");
            System.out.println("3. Запрос книг издательством");
            System.out.println("4. Запрос книг на основе названий книг");
            System.out.println("5. Новая книга");
            System.out.println("6. Изменить количество книг");
            System.out.println("7. Удалить книги");
            System.out.println("8. Вернуться в предыдущее меню");
            System.out.println("-----------------------------");
            System.out.println("Пожалуйста, выберите ваши пункты обслуживания (1-8):");
            int select = input.nextInt();
            switch (select) {
                case 1:// Показать все книги
                    ShowAllBook();
                    break;
                case 2:// Запрос книг по автору
                    selectAuthor();
                    break;
                case 3:// Запрос книг по издателям
                    selectPublisher();
                    break;
                case 4:// Поиск книг по названию
                    selectBookName();
                    break;
                case 5:// Добавить книги
                    insertBook();
                    break;
                case 6:// Редактируем количество книг
                    UpdateBookCount();
                    break;
                case 7:// Удалить книги
                    delete();
                    break;
                case 8:// Вернуться к интерфейсу системы
                    System.out.println("Спасибо за использование и увидимся в следующий раз!");
                    showMenu();
                    break;
                default:
                    showLoginMenu();
                    break;
            }
        }

    }

    // Как отобразить все книги
    public void ShowAllBook() {
        bookimpl.showALLBook();
    }

    // Запрос книг по автору
    public void selectAuthor() {
        System.out.println("Пожалуйста, введите имя автора:");
        String author = input.next();
        bookimpl.adauthor(author);
    }

    // Согласно книге запросов по издателю
    public void selectPublisher() {
        System.out.println("Пожалуйста, введите название издательства:");
        String publisher = input.next();
        bookimpl.adpublisher(publisher);
    }

    // Запрос книг по названию
    public void selectBookName() {
        System.out.println("Пожалуйста, введите название поиска:");
        String bookname = input.next();
        bookimpl.adbookname(bookname);
    }

    // Добавить книгу
    public void insertBook() {
        System.out.println("Добавить книгу");
        System.out.println("Пожалуйста, введите новый номер книги");
        String isbn = input.next();
        System.out.println("Пожалуйста, введите название новой книги");
        String name = input.next();
        System.out.println("Пожалуйста, введите автора новой книги");
        String author1 = input.next();
        System.out.println("Пожалуйста, введите количество новых страниц книги");
        int pag = input.nextInt();
        System.out.println("Пожалуйста, введите нового издателя книги");
        String pub = input.next();
        System.out.println("Пожалуйста, введите количество новых книг");
        int count = input.nextInt();
        bookimpl.addbook(isbn, name, author1, pag, pub, count);
    }

    // Редактируем количество книг
    public void UpdateBookCount() {
        System.out.println("Пожалуйста, введите номер книги, которая будет изменена:");
        String ISBN = input.next();
        System.out.println("Пожалуйста, введите количество книг, которые будут изменены:");
        int bookcount = input.nextInt();
        bookimpl.updatecount(ISBN, bookcount);
    }

    // Удалить книги
    public void delete() {
        System.out.println("Готов удалить книгу");
        System.out.println("Пожалуйста, введите номер книги для удаления:");
        String is = input.next();
        bookimpl.deletebook(is);
    }
}
