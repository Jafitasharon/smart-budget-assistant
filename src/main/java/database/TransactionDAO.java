package database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Transaction;

public class TransactionDAO {

    private static final String DB_URL = "jdbc:sqlite:budget.db";

    public void addTransaction(Transaction txn) {
        String sql = "INSERT INTO transactions(type, amount, category, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txn.getType());
            pstmt.setDouble(2, txn.getAmount());
            pstmt.setString(3, txn.getCategory());
            pstmt.setString(4, txn.getDate());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Error adding transaction: " + e.getMessage());
        }
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Transaction txn = new Transaction(
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getDouble("amount"),
                    rs.getString("category"),
                    rs.getString("date")
                );
                list.add(txn);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching transactions: " + e.getMessage());
        }

        return list;
    }

    public void deleteTransaction(int id) {
        String sql = "DELETE FROM transactions WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("❌ Error deleting transaction: " + e.getMessage());
        }
    }
    
}
