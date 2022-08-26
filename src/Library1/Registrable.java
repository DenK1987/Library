package Library1;

import java.util.List;

public interface Registrable {
    List<Book> getAllList(); // Получить все книги
    boolean addBook(Book book); // Добавить книгу
    boolean deleteBook(Book book); // Удалить книги
    boolean updateBooks(Book book); // Обновить количество книг
}
