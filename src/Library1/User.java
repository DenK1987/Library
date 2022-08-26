package Library1;

public class User {
    private int no;   // Серийный номер
    private String userLogin; // Имя пользователя
    private String userPassword; // пароль пользователя

    public User(int no, String userLogin, String userPassword) {
        this.no = no;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public User(String userLogin) {
        this.userLogin = userLogin;
    }

    public User(int no, String userLogin) {
        this.no = no;
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
