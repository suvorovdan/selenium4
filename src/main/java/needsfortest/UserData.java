package needsfortest;

public class UserData {
    private String email;
    private String password;
    private String name;

    public UserData(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Override
    public String toString() {
        return "пользователь: " + this.name + ", email: " + this.email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
