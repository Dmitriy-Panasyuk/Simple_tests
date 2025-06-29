package roles;

public class DemoQaUser {
    private String login;
    private String password;

    private DemoQaUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static DemoQaUser testUser = new DemoQaUser("qwe123", "k2av5N8TJDhN5!Z");

    public String login() {
        return this.login;
    }

    public String password() {
        return this.password;
    }
}
