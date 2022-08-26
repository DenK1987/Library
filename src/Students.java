import java.util.Scanner;

public class Students {

    Scanner input = new Scanner(System.in);

    Student theStudents[] = new Student[50];

    //books book;


    public static int count = 0;

    public void addStudent(Student s){

        for (int i=0; i<count; i++){

            if(s.regNum.equalsIgnoreCase(theStudents[i].regNum)){

                System.out.println("Студент з № " + s.regNum + " уже зарегистрирован");

                return;
            }

        }

        if (count<=50){

            theStudents[count] = s;
            count++;

        }

    }
    public void showAllStudents(){

        System.out.println("Имя посетителя \t Зарегистрировать номер");

        for (int i=0; i<count; i++){

            System.out.println(theStudents[i].studentName + "\t\t" + theStudents[i].regNum);

        }


    }

    public int isStudent(){
        //return index number of student if available

        //System.out.println("Enter Student Name:");
        //String studentName = input.nextLine();

        System.out.println("Введите номер регистрации:");
        String regNum = input.nextLine();

        for (int i=0; i<count; i++){

            if (theStudents[i].regNum.equalsIgnoreCase(regNum)){

                return i;

            }

        }
        System.out.println("Посетитель не зарегистрирован.");
        System.out.println("Зарегистрируйтесь первым.");


        return -1;

    }
    public void checkOutBook(Books book){
        int studentIndex =this.isStudent();

        if (studentIndex!=-1){
            System.out.println("проверка");

            book.showAllBooks();//jjjjjjjjjjjj
            Book b = book.checkOutBook();
            System.out.println("проверка");
            if (b!= null){

                if (theStudents[studentIndex].booksCount<=3){
                    System.out.println("добавление книги");
                    theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
                    theStudents[studentIndex].booksCount++;
                    return;

                }
                else {
                    System.out.println("Посетитель не может получить больше 3-х книг.");

                    return;

                }
            }
            System.out.println("Книга недоступна.");

        }

    }

    public void checkInBook(Books book){

        int studentIndex = this.isStudent();
        if (studentIndex != -1){
            System.out.println("Серийный номер \\ t \\ t Название книги \\ t \\ tАвтор");

            Student s = theStudents[studentIndex];
            for (int i=0; i<s.booksCount; i++){

                System.out.println(s.borrowedBooks[i].sNo+ "\t\t\t" + s.borrowedBooks[i].bookName + "\t\t\t"+
                        s.borrowedBooks[i].authorName);

            }
            System.out.println("Введите серийный номер книги, которую нужно проверить:");

            int sNo = input.nextInt();
            for (int i=0; i<s.booksCount; i++){

                if (sNo == s.borrowedBooks[i].sNo){

                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i]=null;
                    return;

                }


            }
            System.out.println("Книги № "+sNo+"не найдены");


        }



    }


}