package model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;  // Optional: You can store password or omit it for security.

    // Constructor for creating User after login (without password if you prefer)
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Constructor for registration (if you want)
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
