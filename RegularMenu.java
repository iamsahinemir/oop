import java.util.Scanner;

public class RegularMenu {
    private RegularEmployee employee;

    public RegularMenu(RegularEmployee employee) {
        this.employee = employee;
    }
    /**
     * display the main manager menu using some simple system out commands and switch cases
     * @author Emir Esad Şahin
     * 
     */
    public void displayMenu() {
        String reset = "\u001B[0m";
        String blue = "\033[34m";
        String red = "\033[31m";
        String cyanBold = "\033[1;36m";
        String purple = "\033[35m";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(red + "\n=== EMPLOYEE MENU ===" + employee.getName()+" "+employee.getSurname()+ " ===" +reset);
            System.out.println(blue + "1. Display Profile" + reset);
            System.out.println(cyanBold +"2. Update Profile"+ reset);
            System.out.println(purple +"3. Logout"+ reset);
            System.out.print(red +"Enter your choice: "+ reset);

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        Utils.clearConsole();
                        employee.displayProfile();
                        break;
                    case 2:
                        Utils.clearConsole();
                        updateProfile(scanner);
                        break;
                    case 3:
                        System.out.println("Logging out...");
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
    /**
     * updateProfile updates employees informations in database
     * 
     * @param scanner
     * @author Emir Esad Şahin
     * 
     */
    private void updateProfile(Scanner scanner) {
        while (true) {
            System.out.println("\n=== UPDATE PROFILE ===");
            System.out.println("1. Update Password");
            System.out.println("2. Update Phone Number");
            System.out.println("3. Update Email");
            System.out.println("4. Back to Menu");
            System.out.print("Enter your choice: ");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
    
                switch (choice) {
                    case 1:
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        if (!newPassword.isEmpty()) {
                            employee.updateProfile(newPassword, null, null);
                            System.out.println("Password updated successfully!");
                        } else {
                            System.out.println("Password cannot be empty.");
                        }
                        break;
    
                    case 2:
                        System.out.print("Enter new phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        if (!newPhoneNumber.isEmpty()) {
                            employee.updateProfile(null, newPhoneNumber, null);
                            System.out.println("Phone number updated successfully!");
                        } else {
                            System.out.println("Phone number cannot be empty.");
                        }
                        break;
    
                    case 3:
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        if (!newEmail.isEmpty()) {
                            employee.updateProfile(null, null, newEmail);
                            System.out.println("Email updated successfully!");
                        } else {
                            System.out.println("Email cannot be empty.");
                        }
                        break;
    
                    case 4:
                        System.out.println("Returning to main menu...");
                        Utils.clearConsole();
                        return;
    
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    
}
