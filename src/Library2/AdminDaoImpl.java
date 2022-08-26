package Library2;

import java.util.ArrayList;
import java.util.List;

/**
 * AdminDaoImpl наследует класс AdminDao
 * @author Administrator
 *
 */
public class AdminDaoImpl implements AdminDao {
    List<Admin> adminlist= new ArrayList<>();
    public void init(){
        Admin adm1=new Admin(1,"admin","123456");

        adminlist.add(adm1);
    }
    @Override
    public List<Admin> AdminList() {
        return adminlist;
    }
    @Override
    public boolean insert(Admin admin) {
        return adminlist.add(admin);

    }
}
