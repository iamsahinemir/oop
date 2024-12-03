import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseFacade {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/firm_management_11?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not loaded: " + e.getMessage());
        }
    }
}
