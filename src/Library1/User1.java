package Library1;

public class User1 extends User2{

    public User1(int no, String login, String password) {
        super(no, login, password);
    }

    @Override
    public String getInfo() {
        return "User{" +
                "no=" + getNo() +
                ", userLogin='" + getLogin() + '\'' +
                ", userPassword='" + getPassword() + '\'' +
                '}';
    }
}
