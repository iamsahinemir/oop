import java.util.Scanner;

public class RegularMenu {
    private RegularEmployee employee;

    public RegularMenu(RegularEmployee employee) {
        this.employee = employee;
    }

    public void displayMenu() {
        String reset = "\u001B[0m";
        String blue = "\033[34m";
        String red = "\033[31m";
        String cyanBold = "\033[1;36m";
        String purple = "\033[35m";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(red + "\n=== EMPLOYEE MENU ===" + reset);
            System.out.println(blue + "1. Display Profile" + reset);
            System.out.println(cyanBold +"2. Update Profile"+ reset);
            System.out.println(purple +"3. Logout"+ reset);
            System.out.print(red +"Enter your choice: "+ reset);

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        employee.displayProfile();
                        break;
                    case 2:
                        updateProfile(scanner);
                        break;
                    case 3:
                        System.out.println("Logging out...");
                        Utils.clearConsole(); // Clear the console
                        Main.main(new String[]{}); // Call the Main class's main method
                        return;  // Exiting the menu and going back to the login screen
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private void updateProfile(Scanner scanner) {
        System.out.print("Enter new password (or leave blank to skip): ");
        String newPassword = scanner.nextLine();
        System.out.print("Enter new phone number (or leave blank to skip): ");
        String newPhoneNumber = scanner.nextLine();
        System.out.print("Enter new email (or leave blank to skip): ");
        String newEmail = scanner.nextLine();

        employee.updateProfile(
                newPassword.isEmpty() ? null : newPassword,
                newPhoneNumber.isEmpty() ? null : newPhoneNumber,
                newEmail.isEmpty() ? null : newEmail
        );
    }
}
