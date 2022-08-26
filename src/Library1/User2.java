package Library1;

public abstract class User2 {
    private int no;   // Серийный номер
    private String login; // Имя пользователя
    private String password; // пароль пользователя

    public User2(int no, String login, String password) {
        this.no = no;
        this.login = login;
        this.password = password;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract String getInfo();

}
