
import database.UserDAO;
import model.User;
public class TestUserAuth {
    public static void main(String[] args) {
        // Create user table
        UserDAO.createUserTable();

        // Register a new user
        User newUser = new User("Alice Smith", "alice@example.com", "mypassword123");
        boolean registered = UserDAO.registerUser(newUser);
        if (registered) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Registration failed (maybe user exists).");
        }

        // Try logging in
        User loggedInUser = UserDAO.login("alice@example.com", "mypassword123");
        if (loggedInUser != null) {
            System.out.println("Login successful! Welcome, " + loggedInUser.getName());
        } else {
            System.out.println("Login failed.");
        }
    }
}

