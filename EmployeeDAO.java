import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    public void displayEmployee(String username) {
        String query = "SELECT * FROM employees WHERE username = ?";
        try (Connection conn = DatabaseFacade.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Surname: " + rs.getString("surname"));
                System.out.println("Role: " + rs.getString("role"));
            } else {
                System.out.println("No employee found with username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateProfile(String username, String phoneNo, String email) {
        String query = "UPDATE employees SET phone_no = ?, email = ? WHERE username = ?";
        try (Connection conn = DatabaseFacade.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, phoneNo);
            stmt.setString(2, email);
            stmt.setString(3, username);
    
            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated + " rows updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addEmployee(String username, String password, String role, String name, String surname) {
        String query = "INSERT INTO employees (username, password, role, name, surname) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseFacade.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);
            stmt.setString(4, name);
            stmt.setString(5, surname);
    
            stmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addEmployee(String username, String password, String role, String name, String surname) {
        String query = "INSERT INTO employees (username, password, role, name, surname) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseFacade.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);
            stmt.setString(4, name);
            stmt.setString(5, surname);
    
            stmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteEmployee(String username) {
        String query = "DELETE FROM employees WHERE username = ?";
        try (Connection conn = DatabaseFacade.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, username);
    
            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted + " rows deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
