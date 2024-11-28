import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseFacade {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/firm_management_11";
    private static final String USER = "root"; // MySQL kullanıcı adı
    private static final String PASSWORD = ""; // MySQL şifresi

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Database connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
