import java.util.Scanner;

class Authentication {
    private static final String[][] users = {
        {"admin", "1234", "Manager", "Göktuğ", "Ateş"},
        {"user", "5678", "Employee", "Emre", "Kaya"}
    };

    public static String[] authenticate(String username, String password) {
        for (String[] user : users) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return user;
            }
        }
        return null;
    }
}

public class mainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            boolean isAuthenticated = false;
            String[] authenticatedUser = null;

            System.out.println("=== FIRM MANAGEMENT SYSTEM ===");
            System.out.println("Welcome! Please log in.\n");

            while (!isAuthenticated) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                authenticatedUser = Authentication.authenticate(username, password);
                if (authenticatedUser != null) {
                    isAuthenticated = true;
                    System.out.println("\nLogin successful! Welcome, " 
                        + authenticatedUser[3] + " " + authenticatedUser[4] + "!\n");
                    showRoleMenu(authenticatedUser);
                } else {
                    System.out.println("Invalid username or password. Please try again.\n");
                }
            }
        }
    }

    private static void showRoleMenu(String[] user) {
        Scanner scanner = new Scanner(System.in);
        String role = user[2];
        String name = user[3];
        String surname = user[4];

        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("Welcome, " + name + " " + surname);
            System.out.println("Your Role: " + role);

            if (role.equals("Manager")) {
                System.out.println("1. Update Profile");
                System.out.println("2. View All Employees");
                System.out.println("3. Add Employee (Hire)");
                System.out.println("4. Remove Employee (Fire)");
                System.out.println("5. Logout");
            } else if (role.equals("Employee")) {
                System.out.println("1. View Your Profile");
                System.out.println("2. Update Your Profile");
                System.out.println("3. Logout");
            }

            int choice = validateUserChoice(scanner, 1, role.equals("Manager") ? 5 : 3);
            if (role.equals("Manager")) {
                switch (choice) {
                    case 1:
                        modifyUserProfile(scanner, name, surname);
                        break;
                    case 2:
                        displayAllEmployees();
                        break;
                    case 3:
                        hireEmployee(scanner);
                        break;
                    case 4:
                        fireEmployee(scanner);
                        break;
                    case 5:
                        System.out.println("Returning to login screen...\n");
                        return;
                }
            } else if (role.equals("Employee")) {
                switch (choice) {
                    case 1:
                        showProfile(name, surname);
                        break;
                    case 2:
                        modifyUserProfile(scanner, name, surname);
                        break;
                    case 3:
                        System.out.println("Returning to login screen...\n");
                        return;
                }
            }
        }
    }

    private static int validateUserChoice(Scanner scanner, int min, int max) {
        int option;
        while (true) {
            System.out.print("Choose an option: ");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option >= min && option <= max) {
                    return option;
                } else {
                    System.out.println("Invalid choice. Please select a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    private static void modifyUserProfile(Scanner scanner, String name, String surname) {
        while (true) {
            System.out.println("\n=== UPDATE PROFILE ===");
            System.out.println("Select the information you want to update:");
            System.out.println("1. Password");
            System.out.println("2. Phone Number");
            System.out.println("3. Email");
            System.out.println("4. Exit Update");

            int choice = validateUserChoice(scanner, 1, 4);
            switch (choice) {
                case 1:
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.next();
                    System.out.println("Password updated successfully.");
                    break;
                case 2:
                    System.out.print("Enter new phone number: ");
                    String newPhone = scanner.next();
                    System.out.println("Phone number updated successfully.");
                    break;
                case 3:
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.next();
                    System.out.println("Email updated successfully.");
                    break;
                case 4:
                    System.out.println("Exiting update profile.\n");
                    return;
            }
        }
    }

    private static void displayAllEmployees() {
        System.out.println("Displaying all employees...");
        System.out.println("1. Göktuğ Ateş (Manager)\n2. Emre Kaya (Employee)");
    }

    private static void hireEmployee(Scanner scanner) {
        System.out.println("Enter the details for the new employee:");
        System.out.print("First Name: ");
        String newName = scanner.next();
        System.out.print("Last Name: ");
        String newSurname = scanner.next();
        System.out.print("Role: ");
        String newRole = scanner.next();
        System.out.println(newName + " " + newSurname + " has been added as a " + newRole + ".");
    }

    private static void fireEmployee(Scanner scanner) {
        System.out.print("Enter the name of the employee to remove: ");
        String name = scanner.next();
        System.out.println(name + " has been removed.");
    }

    private static void showProfile(String name, String surname) {
        System.out.println("Your Profile:");
        System.out.println("First Name: " + name);
        System.out.println("Last Name: " + surname);
    }
}
