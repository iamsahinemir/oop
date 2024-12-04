import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
/**
 * Login class provides to the user for login to system .
 * 
 * 
 * @author Emir Esad Sahin
 */
public class Login {
    /**
     * void is menu screen
     * There are colors
     * Checks roles
     * Checks defaultpassword situation
     * Checks authentication
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String BLUE = "\u001B[34m";
        String YELLOW = "\u001B[33m";
        System.out.println(BLUE + "== WELCOME TO FIRM MANAGEMENT SYSTEM ==" + RESET);
        System.out.print(YELLOW + "Enter your username: " + RESET);
        String username = scanner.nextLine();
        System.out.print(YELLOW + "Enter your password: " + RESET);
        String password = scanner.nextLine();

        Authentication auth = new Authentication();
        String role = auth.authenticate(username, password);

        if (password.equals("defaultpassword")) {
            System.out.println(RED + "You are using the default password. Please change your password." + RESET);
            changePassword(username);
            start();
        }

        if (role.equals("manager")) {
            Manager manager = getManagerDetails(username);
            if (manager != null) {
                Utils.clearConsole();
                System.out.println(GREEN + "Login successful. Redirecting to Manager Menu..." + RESET);
                new ManagerMenu(manager).displayMenu();
            } else {
                Utils.clearConsole();
                System.out.println(RED + "Error: Unable to fetch manager details." + RESET);
            }
        } else if (role.equals("technician") || role.equals("intern") || role.equals("engineer")) {
            RegularEmployee employee = getEmployeeDetails(username);
            if (employee != null) {
                Utils.clearConsole();
                System.out.println(GREEN + "Login successful. Redirecting to Employee Menu..." + RESET);
                new RegularMenu(employee).displayMenu();
            } else {
                Utils.clearConsole();
                System.out.println(RED + "Error: Unable to fetch employee details." + RESET);
            }
        } else {
            Utils.clearConsole();
            System.out.println(RED + "Invalid login. Please try again." + RESET);
            start();
        }

        scanner.close();
    }


    /**
     * Collects Manager details from database
     * @return Manager
     */
    private Manager getManagerDetails(String username) {
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "SELECT * FROM employees WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Manager(
                    rs.getInt("e_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("phone_number"),
                    rs.getString("dateofbirth"),
                    rs.getString("dateofstart"),
                    rs.getString("email")
                );
            }
        } catch (Exception e) {
            System.out.println("Error fetching manager details: " + e.getMessage());
        }
        return null;
    }


    /**
     * Collects Employee details from database
     * @return Regular Employee
     */
    private RegularEmployee getEmployeeDetails(String username) {
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "SELECT * FROM employees WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new RegularEmployee(
                    rs.getInt("e_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("phone_number"),
                    rs.getString("dateofbirth"),
                    rs.getString("dateofstart"),
                    rs.getString("email")
                );
            }
        } catch (Exception e) {
            System.out.println("Error fetching employee details: " + e.getMessage());
        }
        return null;
    }


    /**
     * If there is defaultpassword situation, changes to new password
     * Checks username and password
     * @return Regular Employee
     */
    private void changePassword(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your new password: ");
        String newPassword = scanner.nextLine();

        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "UPDATE employees SET password = ? WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newPassword);
            stmt.setString(2, username);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Password updated successfully. Please log in again.");
            } else {
                System.out.println("Error updating password. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Error changing password: " + e.getMessage());
        }
    }
}
