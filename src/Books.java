import java.util.Scanner;

public class Books {


    Book theBooks[] = new Book[50];     // Array that stores 'book' Objects.
    public static int count;    // Counter for No of book objects Added in Array.

    Scanner input = new Scanner(System.in);


    public int compareBookObjects(Book b1, Book b2) {
        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
            System.out.println("Книга с таким название уже существует.");
            return 0;
        }

        if (b1.sNo == b2.sNo) {
            System.out.println("Книги с таким серийным номером уже не существует.");
            return 0;
        }
        return 1;
    }

    public void addBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (this.compareBookObjects(b, this.theBooks[i]) == 0)
                return;
        }
        if (count < 50) {
            theBooks[count] = b;
            count++;
        } else {
            System.out.println("Не хватает места, чтобы добавить больше книг.");
        }
    }

    public void searchBySno() {
        System.out.println("\t\t\t\tПОИСК ПО СЕРИЙНОМУ НОМЕРУ\n");

        int sNo;
        System.out.println("Введите серийный номер книги:");
        sNo = input.nextInt();
        int flag = 0;
        System.out.println("\r\n" + "№ \\ t \\ t Название \\ t \\ t Автор \\ t \\ t Доступное количество \\ t \\ t Общее количество \"");


        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" +
                        theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("Нет книги по серийному номеру " + sNo + " Нашел.");
    }

    public void searchByAuthorName() {
        System.out.println("\t\t\t\t ПОИСК ИМЯ АВТОРА");
        input.nextLine();
        System.out.println("Введите имя автора:");
        String authorName = input.nextLine();
        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        System.out.println("S.No \\ t \\ t Название \\ t \\ t Автор \\ t \\ t Доступное количество \\ t \\ t Общее количество");
        for (int i = 0; i < count; i++) {
            if (authorName.equalsIgnoreCase(theBooks[i].authorName)) {
                System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" +
                        theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
                flag++;
            }
        }
        if (flag == 0)
            System.out.println("Книги - " + authorName + " не найдено.");

    }

    public void showAllBooks() {
        System.out.println("\t\t\t\tПОКАЗАТЬ ВСЕ КНИГИ\n");
        System.out.println("S.No \\ t \\ t Название \\ t \\ tАвтор \\ t \\ tДоступное количество t\\tВсего");

        for (int i = 0; i < count; i++) {
            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" +
                    theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
        }
    }

    public void upgradeBookQty() {
        System.out.println("\t\t\t\tОБНОВЛЕНИЕ КОЛИЧЕСТВА КНИГ\n");
        System.out.println("ВВведите серийный номер книги:");
        int sNo = input.nextInt();
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println("Введите № книг для добавления:");
                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;
                return;
            }
        }
    }

    public void dispMenu() {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Введите 0 для выхода из программы.");
        System.out.println();
        System.out.println("Введите 1, чтобы добавить новую книгу.");

        System.out.println();

        System.out.println("Введите 2, чтобы обновить количество книг.");
        System.out.println();

        System.out.println("Введите 3 для поиска книги.");
        System.out.println();

        System.out.println("Введите 4, чтобы показать все книги.");
        System.out.println();

        System.out.println("Введите 5, чтобы зарегистрировать посетителя.");
        System.out.println();

        System.out.println("Введите 6, чтобы показать всех зарегистрированных посетителей");
        System.out.println();

        System.out.println("Введите 7, чтобы проверить книгу.");
        System.out.println();

        System.out.println("Введите 8, чтобы зарегистрироваться.");
        System.out.println("---------------------------------------------");

    }

    public int isAvailable(int sNo) {
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) {
                    System.out.println("Книга доступна.");
                    return i;
                }
                System.out.println("Книга недоступна.");
                return -1;
            }
        }
        System.out.println("В библиотеке нет книги № " + "");
        System.out.println("Нет книги с серийным номером " + " Доступно в библиотеке.");
        return -1;
    }

    public Book checkOutBook() {
        System.out.println("Введите серийный номер книги, которую нужно проверить.");

        int sNo = input.nextInt();
        int bookIndex = isAvailable(sNo);
        if (bookIndex != -1) {
            //int bookIndex = isAvailable(sNo);
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }

    public void checkInBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}