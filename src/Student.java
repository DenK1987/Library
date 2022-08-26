import java.util.Scanner;

public class Student {


    String studentName;
    String regNum;

    Book[] borrowedBooks = new Book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);

    public Student(){

        System.out.println("Введите имя посетителя:");
        this.studentName = input.nextLine();

        System.out.println("Введите номер регистрации:");
        this.regNum = input.nextLine();

    }
}