import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
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

        if (role.equals("manager")) {
            Manager manager = getManagerDetails(username);
            if (manager != null) {
                

                System.out.println(GREEN + "Login successful. Redirecting to Manager Menu..." + RESET);
                new ManagerMenu(manager).displayMenu();
            } else {
                System.out.println(RED + "Error: Unable to fetch manager details." + RESET);
            }
        } else if (role.equals("technician") || role.equals("intern") || role.equals("engineer")) {
            RegularEmployee employee = getEmployeeDetails(username);
            if (employee != null) {
                System.out.println(GREEN + "Login successful. Redirecting to Employee Menu..." + RESET);
                new RegularMenu(employee).displayMenu();
            } else {
                System.out.println(RED + "Error: Unable to fetch employee details." + RESET);
            }
        } else {
            System.out.println(RED + "Invalid login. Please try again." + RESET);
            start();
        }
    }

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
}
