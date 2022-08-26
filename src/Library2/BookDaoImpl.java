package Library2;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    List<Book> booklist=new ArrayList<Book>();
    public void init(){
        Book book1=new Book("ISBN1001","Путешествие на Запад","У Ченген",100,"Народный Издательский Дом",20);
        Book book2=new Book("ISBN1002","Если ты дашь мне три дня света","Чжан Сан",100,"Издательство Хэфэй",15);
        Book book3=new Book("ISBN1003","Мечта о красных особняках","Ли Си",100,"Народный Издательский Дом",25);
        Book book4=new Book("ISBN1004","Как делают сталь","Cuihua",100,"Пекинский издательский дом",10);
        Book book5=new Book("ISBN1005","Три королевства","Ван Ву",100,"Народный Издательский Дом",30);
        Book book6=new Book("ISBN1006","Романтика трех королевств","Ван Ву",100,"Народный Издательский Дом",30);
        booklist.add(book1);
        booklist.add(book2);
        booklist.add(book3);
        booklist.add(book4);
        booklist.add(book5);
        booklist.add(book6);
    }
    @Override
    public List<Book> getAllList() {
        return booklist;
    }
    @Override
    public boolean addbook(Book book) {
        return booklist.add(book);
    }
    @Override
    public boolean updatebook(Book book) {
        return false;
    }
    @Override
    public boolean deletebook(Book book) {
        return false;
    }
}