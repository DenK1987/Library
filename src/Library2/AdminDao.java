package Library2;

import java.util.List;


/**
 * Интерфейс администратора
 * @author Administrator
 *
 */
public interface AdminDao{

    public List<Admin> AdminList();
    public boolean insert(Admin admin);

}
