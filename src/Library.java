import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        System.out.println("********************Добро пожаловать в нашу библиотеку!********************");
        System.out.println("Будьте добры, выберите из следующих вариантов:");

        Scanner input = new Scanner(System.in);
        Books ob = new Books();
        Students obStudent = new Students();
        int choice;
        int searchChoice;

        do {

            ob.dispMenu();

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    Book b = new Book();
                    ob.addBook(b);
                    break;

                case 2:
                    ob.upgradeBookQty();
                    break;

                case 3:
                    System.out.println("Введите 1 для поиска по серийному номеру №");
                    System.out.println("ВВедите 2 для поиска по имени автора (полное имя)");
                    searchChoice = input.nextInt();

                    switch (searchChoice) {

                        case 1:
                            ob.searchBySno();
                            break;
                        case 2:
                            ob.searchByAuthorName();

                    }
                    break;

                case 4:
                    ob.showAllBooks();
                    break;
                case 5:
                    Student s = new Student();
                    obStudent.addStudent(s);
                    break;
                case 6:
                    obStudent.showAllStudents();
                    break;
                case 7:
                    obStudent.checkOutBook(ob);
                    break;
                case 8:
                    obStudent.checkInBook(ob);
                    break;
                default:
                    System.out.println("Выбор должен быть в диапазоне 0-8");


            }

        }
        while (choice != 0);

    }

}