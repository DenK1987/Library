package Library1;


import java.util.ArrayList;
import java.util.List;

/**
 * AdminDaoImpl наследует класс AdminDao
 *
 * @author Administrator
 */
public class UserBase implements UserInterface {
    List<User> userlist = new ArrayList<>();

    public void init() {
        User admin = new User(0,"admin", "admin");

        userlist.add(admin);
    }

    @Override
    public List<User> UserList() {
        return userlist;
    }

    @Override
    public boolean insert(User user) {
        return userlist.add(user);

    }
}