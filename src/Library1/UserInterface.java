package Library1;


import java.util.List;

/**
 * Интерфейс администратора
 *
 * @author Administrator
 */


public interface UserInterface {

    public List<User> UserList();

    public boolean insert(User user);

}