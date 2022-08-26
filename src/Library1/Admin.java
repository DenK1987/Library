package Library1;

public class Admin {
    private String adminLogin; // Имя пользователя
    private String adminPassword; // пароль пользователя

    public Admin(String adminLogin, String adminPassword) {
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin [login: " + adminLogin + ", password: " + adminPassword + "]";
    }

//    public Admin() {
//        super();
//    }


    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}