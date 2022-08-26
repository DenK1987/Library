package Library1;


import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);
    //BookBizImpl bookimpl = new BookBizImpl(); //удалить потом, это library
    Library library = new Library();

    public BookMenu() {
        library.bookRegister.initBooks();
        library.userBase.init();
    }

    /**
     * Метод для входа в меню
     */
    public void showMenu() {
        while (true) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("          Добро пожаловать в нашу онлайн-библиотеку!          ");
            System.out.println("--------------------------------------------------------------");
            System.out.println("1. Вход от имени администратора");
            System.out.println("2. Вход для пользователей");
            System.out.println("3. Регистрация");
            System.out.println("4. Выход из меню");
            System.out.println("--------------------------------------------------------------");
            System.out.print("Выберите необходимую операцию: ");
            int item = sc.nextInt();
            switch (item) {
                case 1: // Вход от имени администратора
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("Введите учетную запись администратора: ");
                    String adminLogin = sc.next();
                    System.out.print("Введите пароль администратора: ");
                    String adminPassword = sc.next();
                    boolean isLoginSuccessForAdmin = library.checkLoginForAdmin(adminLogin, adminPassword);
                    if (isLoginSuccessForAdmin) {
                        showAdminLoginMenu();
                    }
                    break;
                case 2: // Вход для пользователей
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("Введите имя пользователя: ");
                    String userLogin = sc.next();
                    System.out.print("Введите пароль: ");
                    String userPassword = sc.next();
                    boolean isLoginSuccessForUser = library.checkLoginForUser(userLogin, userPassword);
                    if (isLoginSuccessForUser) {
                        showUserLoginMenu();
                    }
                    break;
                case 3: // Регистрация
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("Введите имя пользователя: ");
                    String login = sc.next();
                    System.out.print("Введите пароль: ");
                    String password = sc.next();
                    library.userRegistration(login, password);
                    break;
                case 4: // Выход
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("            Будем рады вас видеть в следующий раз!            ");
                    System.out.println("--------------------------------------------------------------");
                    System.exit(1);
                    break;
                default:
                    showMenu();
                    break;
            }
        }
    }

    /**
     * Фоновая операция после успешного входа
     */
    private void showAdminLoginMenu() {
        while (true) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("       Добро пожаловать в меню управления библиотекой!       ");
            System.out.println("--------------------------------------------------------------");
            //System.out.println("1. Список зарегистрированных пользователей");
            System.out.println("1. Список всех книг");
            System.out.println("2. Поиск книги по названию");
            System.out.println("3. Поиск книг по жанру");
            System.out.println("4. Поиск книг по автору");
            System.out.println("5. Добавить новые книги");
            System.out.println("6. Изменить количество книг");
            System.out.println("7. Удалить книги");
            System.out.println("8. Вернуться в предыдущее меню");
            System.out.println("--------------------------------------------------------------");
            System.out.print("Выберите необходимую для вас операцию (1-8): ");
            int item = sc.nextInt();
            switch (item) {
                case 1: // Показать все книги
                    library.showALLBooks();
                    break;
                case 2: // Поиск книги по названию
                    boolean isThereBookWithThisTitle = library.searchForBookByName();
                    if (!isThereBookWithThisTitle) {
                        System.out.println("\nКнига не найдена!");
                    }
                    break;
                case 3: // Поиск книг по жанру
                    library.searchForBookByGenre();
                    //selectGenre();
                    break;
                case 4: // Поиск книг по автору
                    selectAuthor();
                    break;
                case 5: // Добавить новые книги
                    insertBook();
                    break;
                case 6: // Изменить количество книг
                    UpdateBookCount();
                    break;
                case 7: // Удалить книги
                    delete();
                    break;
                case 8: // Вернуться в основное меню
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Спасибо, что посетили нашу библиотеку!");
                    System.out.println("Увидимся в следующий раз!");
                    showMenu();
                    break;
                default:
                    showAdminLoginMenu();
                    break;
            }
        }
    }

    /**
     * Фоновая операция после успешного входа
     */
    public void showUserLoginMenu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("       Добро пожаловать в меню управления библиотекой!       ");
        System.out.println("--------------------------------------------------------------");
        System.out.println("1. Список всех книг");
        System.out.println("2. Поиск книги по названию");
        System.out.println("3. Поиск книг по жанру");
        System.out.println("4. Поиск книг по автору");
        System.out.println("5. Вернуться в предыдущее меню");
        System.out.println("--------------------------------------------------------------");
        System.out.print("Выберите необходимую для вас операцию (1-5): ");
        int item = sc.nextInt();
        switch (item) {
            case 1: // Показать все книги
                showAllBooks();
                break;
            case 2: // Поиск книги по названию
                library.searchForBookByName();
                break;
            case 3: // Поиск книг по жанру
                selectGenre();
                break;
            case 4: // Поиск книг по автору
                selectAuthor();
                break;
            case 5: // Вернуться в основное меню
                System.out.println("--------------------------------------------------------------");
                System.out.println("Спасибо, что посетили нашу библиотеку!");
                System.out.println("Увидимся в следующий раз!");
                showMenu();
                break;
            default:
                showUserLoginMenu();
                break;
        }
    }

    // Как отобразить все книги
    public void showAllBooks() {
        library.showALLBooks();
    }

    // Поиск книги по названию
    public void searchForBookByName() {


    }

    // Запрос книг по автору
    public void selectAuthor() {
        System.out.println("Пожалуйста, введите имя автора:");
        String author = sc.nextLine();
        library.adauthor(author);
    }

    // Запрос книг по жанру
    public void selectGenre() {
        System.out.println("Пожалуйста, введите жанр книги:");
        String genre = sc.nextLine();
        library.searchForBookByGenre();
    }

    // Добавить книгу
    public void insertBook() {
        System.out.println("Добавить книгу");
        System.out.println("Пожалуйста, введите новый номер книги");
        String isbn = sc.next();
        System.out.println("Пожалуйста, введите название новой книги");
        String name = sc.next();
        System.out.println("Пожалуйста, введите автора новой книги");
        String author = sc.next();

        System.out.println("Пожалуйста, введите жанр новой книги");
        String genre = sc.next();
        System.out.println("Пожалуйста, введите количество новых книг");
        int count = sc.nextInt();
        library.addbook(isbn, name, author, genre, count);
    }

    // Редактируем количество книг
    public void UpdateBookCount() {
        System.out.println("Пожалуйста, введите номер книги, которая будет изменена:");
        String ISBN = sc.next();
        System.out.println("Пожалуйста, введите количество книг, которые будут изменены:");
        int bookcount = sc.nextInt();
        library.updatecount(ISBN, bookcount);
    }

    // Удалить книги
    public void delete() {
        System.out.println("Готов удалить книгу");
        System.out.println("Пожалуйста, введите номер книги для удаления:");
        String is = sc.next();
        library.deletebook(is);
    }
}
