package Library2;

import java.util.List;

public interface BookDao {
    public List<Book> getAllList();// Получить все книги
    public boolean addbook(Book book);// Добавить книгу
    public boolean deletebook(Book book);// Удалить книги
    public boolean updatebook(Book book); // Редактируем количество книг
}
