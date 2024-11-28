import java.util.Scanner;

public class TestDatabaseOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n--- Firm Management System ---");
            System.out.println("1. Display Employee by Username");
            System.out.println("2. Update Employee Profile");
            System.out.println("3. Add New Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Display Employee
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    dao.displayEmployee(username);
                    break;

                case 2: // Update Profile
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String phoneNo = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String email = scanner.nextLine();
                    dao.updateProfile(username, phoneNo, email);
                    break;

                case 3: // Add Employee
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter role (manager/engineer/technician/intern): ");
                    String role = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter surname: ");
                    String surname = scanner.nextLine();
                    dao.addEmployee(username, password, role, name, surname);
                    break;

                case 4: // Delete Employee
                    System.out.print("Enter username to delete: ");
                    username = scanner.nextLine();
                    dao.deleteEmployee(username);
                    break;

                case 5: // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}
