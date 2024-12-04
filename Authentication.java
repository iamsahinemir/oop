import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Authentication {

    private static String loggedInName;
    private static String loggedInSurname;

    public static void setLoggedInUser(String name, String surname) {
        loggedInName = name;
        loggedInSurname = surname;
    }

    public static String getLoggedInName() {
        return loggedInName;
    }

    public static String getLoggedInSurname() {
        return loggedInSurname;
    }

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
    }//tekrar
}
