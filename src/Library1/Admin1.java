package Library1;

public class Admin1 extends User2{


    public Admin1(int no, String login, String password) {
        super(no, login, password);
    }

    @Override
    public String getInfo() {
        return "Admin{" +
                "no=" + getNo() +
                ", adminLogin='" + getLogin() + '\'' +
                ", adminPassword='" + getPassword() + '\'' +
                '}';
    }
}
