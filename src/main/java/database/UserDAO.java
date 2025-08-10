// src/database/UserDAO.java
package database;

import java.sql.*;

import model.User;

public class UserDAO {

    public static void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "name TEXT,"+
                     "email TEXT UNIQUE NOT NULL," +
                     "password TEXT,"+
                     "oauth_provider TEXT,"+
                     "oauth_id TEXT"+
                     ")";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            stmt.execute("CREATE UNIQUE INDEX IF NOT EXISTS idx_oauth_unique ON users (oauth_provider, oauth_id)");
        } catch (SQLException e) {
            System.out.println("Error creating user table: " + e.getMessage());
        }
    }

    public static boolean registerUser(User user) {
        String sql = "INSERT INTO users (name,email, password) VALUES (?, ?,?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3,user.getPassword());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Registration error: " + e.getMessage());
            return false;
        }
    }

    public static User login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email.trim().toLowerCase());
            pstmt.setString(2, password.trim());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            } else{
                System.out.println("Invalid email or password.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
         }
    }  
    
    public static User findUserByOAuth(String provider, String oauthId) {
        String sql = "SELECT * FROM users WHERE oauth_provider = ? AND oauth_id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, provider);
            pstmt.setString(2, oauthId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User createOAuthUser(String provider, String oauthId, String name, String email) {
        String sql = "INSERT INTO users (name, email,password, oauth_provider, oauth_id) VALUES (?, ?,NULL, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, provider);
            pstmt.setString(4, oauthId);
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) {
                return new User(keys.getInt(1), name, email);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}