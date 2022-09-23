package Library1;

public class User {
    private int registrationNumber;   // Номер регистрации
    private String userLogin; // Имя пользователя
    private String userPassword; // пароль пользователя

    public User(int registrationNumber, String userLogin, String userPassword) {
        this.registrationNumber = registrationNumber;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public User(String userLogin) {
        this.userLogin = userLogin;
    }

    public User(int registrationNumber, String userLogin) {
        this.registrationNumber = registrationNumber;
        this.userLogin = userLogin;
    }

    public String getUsersInfo() {
        return String.format("\t\t%-10d|\t %-23s|\t%-16s|", registrationNumber, userLogin, userPassword);
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
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
