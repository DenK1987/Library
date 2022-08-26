package Library2;

public class Admin {
    private int no;   // Серийный номер
    private String adid; // Имя пользователя
    private String adpwd;// пароль пользователя

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getAdid() {
        return adid;
    }
    public void setAdid(String adid) {
        this.adid = adid;
    }
    public String getAdpwd() {
        return adpwd;
    }
    public void setAdpwd(String adpwd) {
        this.adpwd = adpwd;
    }

    public Admin(int no, String adid, String adpwd) {
        super();
        this.no = no;
        this.adid = adid;
        this.adpwd = adpwd;
    }
    @Override
    public String toString() {
        return "Admin [no=" + no + ", adid=" + adid + ", adpwd=" + adpwd + "]";
    }
    public Admin() {
        super();
    }
}
