import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseFacade {
    private static final String DB_URL="jdbc:mysql://localhost:3306/firm_management_11";
    private static final String USER="root";
    private static final String PASSWORD="";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
