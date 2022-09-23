package Library1;


import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);
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
            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println("          Добро пожаловать в нашу онлайн-библиотеку!          ");
            System.out.println("--------------------------------------------------------------");
            System.out.println("1. Вход от имени администратора");
            System.out.println("2. Вход для пользователей");
            System.out.println("3. Регистрация");
            System.out.println("4. Выход из меню");
            System.out.println("--------------------------------------------------------------");
            int item;
            System.out.print("Выберите необходимую операцию: ");
            while (!sc.hasNextInt()) {
                System.err.println("ОШИБКА! Некорректный ввод!");
                System.out.print("\nВыберите необходимую операцию от 1 до 4: ");
                sc.next();
            }
            item = sc.nextInt();
            if (item <= 0 || item >= 5) {
                System.err.println("ОШИБКА! Некорректный ввод!");
                System.out.print("\nВыберите необходимую операцию от 1 до 4: ");
            }
            switch (item) {
                case 1: // Вход от имени администратора
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Вход от имени администратора\n");
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
                    System.out.println("Вход для пользователей\n");
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
                    System.out.println("Регистрация\n");
                    System.out.print("Введите имя пользователя: ");
                    String login = sc.next();
                    System.out.print("Введите пароль: ");
                    String password = sc.next();
                    library.userRegistration(login, password);
                    break;
                case 4: // Выход
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Будем рады вас видеть в следующий раз!");
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
     * Фоновая операция после успешного входа для администратора
     */
    private void showAdminLoginMenu() {
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println("       Добро пожаловать в меню управления библиотекой!       ");
            System.out.println("--------------------------------------------------------------");
            System.out.println("1. Список зарегистрированных пользователей");
            System.out.println("2. Список всех книг");
            System.out.println("3. Поиск книги по названию");
            System.out.println("4. Поиск книг по жанру");
            System.out.println("5. Поиск книг по автору");
//            System.out.println("6. Взять книги для чтения");
//            System.out.println("7. Список книг, взятых пользователем для чтения");
            System.out.println("6. Добавить новые книги");
            System.out.println("7. Изменить количество экземпляров книги");
            System.out.println("8. Удалить книги");
            System.out.println("9. Вернуться в предыдущее меню");
            System.out.println("--------------------------------------------------------------");
            System.out.print("Выберите необходимую для вас операцию: ");
            int item;
            while (!sc.hasNextInt()) {
                System.err.println("ОШИБКА! Некорректный ввод!");
                System.out.print("\nВыберите необходимую для вас операцию от 1 до 9: ");
                sc.next();
            }
            item = sc.nextInt();
            if (item <= 0 || item > 9) {
                System.err.println("ОШИБКА! Некорректный ввод!");
                System.out.print("\nВыберите необходимую операцию от 1 до 9 ");
            }
            switch (item) {
                case 1: // Показать всех пользователей
                    library.showAllUsers();
                    break;
                case 2: // Показать все книги
                    library.showAllBooks();
                    break;
                case 3: // Поиск книги по названию
                    library.searchForBookByName();
                    break;
                case 4: // Поиск книг по жанру
                    library.searchForBookByGenre();
                    break;
                case 5: // Поиск книг по автору
                    library.searchForBookByAuthor();
                    break;
//                case 6: // Взять книги для чтения
//                    //library.addBook();
//                    break;
//                case 7: // Взять книги для чтения
//                    //library.addBook();
//                    break;
                case 6: // Добавить новые книги
                    library.addBook();
                    break;
                case 7: // Изменить количество экземпляров книги
                    library.changeCountCopiesBook();
                    break;
                case 8: // Удалить книги
                    library.deleteBook();
                    break;
                case 9: // Вернуться в основное меню
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Спасибо, что посетили нашу библиотеку!");
                    System.out.println("Увидимся в следующий раз!");
                    System.out.println("--------------------------------------------------------------");
                    showMenu();
                    break;
                default:
                    showAdminLoginMenu();
                    break;
            }
        }
    }

    /**
     * Фоновая операция после успешного входа для пользователя
     */
    public void showUserLoginMenu() {
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println("       Добро пожаловать в меню управления библиотекой!       ");
            System.out.println("--------------------------------------------------------------");
            System.out.println("1. Список всех книг");
            System.out.println("2. Поиск книги по названию");
            System.out.println("3. Поиск книг по жанру");
            System.out.println("4. Поиск книг по автору");
            System.out.println("5. Вернуться в предыдущее меню");
            System.out.println("--------------------------------------------------------------");
            System.out.print("Выберите необходимую для вас операцию: ");
            int item;
            while (!sc.hasNextInt()) {
                System.err.println("ОШИБКА! Некорректный ввод!");
                System.out.print("\nВыберите необходимую для вас операцию от 1 до 5: ");
                sc.next();
            }
            item = sc.nextInt();
            if (item <= 0 || item > 5) {
                System.err.println("ОШИБКА! Некорректный ввод!");
                System.out.print("\nВыберите необходимую операцию от 1 до 5 ");
            }
            switch (item) {
                case 1: // Показать все книги
                    library.showAllBooks();
                    break;
                case 2: // Поиск книги по названию
                    library.searchForBookByName();
                    break;
                case 3: // Поиск книг по жанру
                    library.searchForBookByGenre();
                    break;
                case 4: // Поиск книг по автору
                    library.searchForBookByAuthor();
                    break;
                case 5: // Вернуться в основное меню
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Спасибо, что посетили нашу библиотеку!");
                    System.out.println("Увидимся в следующий раз!");
                    System.out.println("--------------------------------------------------------------");
                    showMenu();
                    break;
                default:
                    showUserLoginMenu();
                    break;
            }
        }
    }

}
