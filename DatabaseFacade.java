/**
 * DatabaseFacade class provides access MYSQL database.
 * Connection class between database and program.
 * 
 * @author Emir Esad Sahin
 */
import java.sql.Connection;
import java.sql.DriverManager;

/**
     * Connects database
     * DB_URL is url for localhost database
     * USER is root for root user
     * PASSWORD is password for database. There is no password.
     *
     */
public class DatabaseFacade {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/firm_management_11?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
    //try-catch exception for driver for connection between java and mysql
    //In Visual Studio Code, Main clas should Run Java, no Run Code.
    //If User Run Code, "MySQL JDBC Driver not loaded: " message occur.
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not loaded: " + e.getMessage());
        }
    }
}
