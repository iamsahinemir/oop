import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * Authentication class checks variables from database for user login.
 * 
 * 
 * @author Emir Esad Şahin
 */
public class Authentication {
    /**
     * This takes user input for the size of the array to generate.
     *@return name, surname, username, password, role.
     */
    private static String loggedInName;
    private static String loggedInSurname;

    public static void setLoggedInUser(String name, String surname) {
        loggedInName = name;
        loggedInSurname = surname;
    }
    /**
     * It collects loggedınname
     *
     * 
     * @return  loggedInName
     */
    public static String getLoggedInName() {
        return loggedInName;
    }
    /**
     * It collects loggedınsurname
     *
     * 
     * @return  loggedInSurname
     */
    public static String getLoggedInSurname() {
        return loggedInSurname;
    }
    /**
     * It collects username, password and role
     *
     * @param username
     * @param password
     * @return  role
     */
    public String authenticate(String username, String password) {
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "SELECT username, password, role, name, surname FROM employees WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return "invalid";
    }
}
