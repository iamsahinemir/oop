import java.util.Arrays;
import java.util.Scanner;
public class ManagerMenu {
    private Manager manager;

    public ManagerMenu(Manager manager) {
        this.manager = manager;
    }
    
    /**
     * display the main manager menu using some simple system out commands and switch cases
     * @author Emir Esad Şahin
     * @author Tunahan Tuze
     * @author Dilvin Aydın
     * @author Zülal Sönmez
     */
    public void displayMenu() {
        String reset = "\u001B[0m";          
        String greenBold = "\033[1;32m";    
        String blue = "\033[34m";           
        String cyan = "\033[36m";           
        String purple = "\033[35m";         
        String yellow = "\033[33m";         
        String red = "\033[31m";            
        String blueBold = "\033[1;34m";     
        String magenta = "\033[35m";        
        String cyanBold = "\033[1;36m";     
        String whiteBold = "\033[1;37m";    
        Scanner scanner = new Scanner(System.in);
        while (true) {



            System.out.println(greenBold + "\n=== MANAGER MENU - " + manager.getName() + " " + manager.getSurname() + " ===" + reset);
            System.out.println(blue + "1. Display All Employees" + reset);
            System.out.println(cyan + "2. Display Employees by Role" + reset);
            System.out.println(purple + "3. Display Employee by Username" + reset);
            System.out.println(yellow + "4. Update Employee Non-Profile Fields" + reset);
            System.out.println(greenBold + "5. Hire New Employee" + reset);
            System.out.println(red + "6. Fire Employee" + reset);
            System.out.println(blueBold + "7. Update Own Profile" + reset);
            System.out.println(magenta + "8. Run Sorting Algorithms" + reset);
            System.out.println(cyanBold + "9. Logout" + reset);
            System.out.print(whiteBold + "Enter your choice: " + reset);



            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        Utils.clearConsole();
                        manager.displayAllEmployees();
                        break;
                    case 2:
                        Utils.clearConsole();
                        displayEmployeesByRole(scanner);
                        break;
                    case 3:
                        Utils.clearConsole();
                        displayEmployeeByUsername(scanner);
                        break;
                    case 4:
                        Utils.clearConsole();
                        updateEmployeeNonProfile(scanner);
                        break;
                    case 5:
                        Utils.clearConsole();
                        hireNewEmployee(scanner);
                        break;
                    case 6:
                        Utils.clearConsole();
                        fireEmployee(scanner);
                        break;
                    case 7:
                        Utils.clearConsole();
                        updateOwnProfile(scanner);
                        break;
                    case 8:
                        Utils.clearConsole();
                        runSortingAlgorithms(scanner);
                        
                        break;
                    case 9:
                        System.out.println("Logging out...");
                        Utils.clearConsole();
                        Main.main(new String[]{}); 
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1-9).");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); 
            }
        }
    }

    /**
     * asks manager to enter a role to sort employees by their roles
     * @author Emir Esad Şahin
     */
    private void displayEmployeesByRole(Scanner scanner) {
        System.out.print("Enter role (e.g., technician, engineer, intern, manager): ");
        String role = scanner.nextLine();
    
        //list of valid roles
        String[] validRoles = {"technician", "engineer", "intern", "manager"};
    
        
        boolean isValidRole = Arrays.stream(validRoles)
                                    .anyMatch(validRole -> validRole.equalsIgnoreCase(role));
                                    Utils.clearConsole();
        if (!isValidRole) {
            Utils.clearConsole();
            System.out.println("Invalid role. Allowed roles: technician, engineer, intern, manager.");
            return;
        }
    
        
        try {
            manager.displayEmployeesWithRole(role);
        } catch (Exception e) {
            System.out.println("Error displaying employees with the specified role: " + e.getMessage());
        }
    }
    
    
    /**
     * asks manager to enter a employee username to display information
     * provokes related method from manager class
     * @author Emir Esad Şahin
     */
    private void displayEmployeeByUsername(Scanner scanner) {
        System.out.print("Enter the username of the employee: ");
        String username = scanner.nextLine();
        Utils.clearConsole();
    
        try {
            manager.displayEmployeeByUsername(username);
        } catch (Exception e) {
            System.out.println("Error displaying employee details: " + e.getMessage());
        }
    }
    
    /**
     * asks manager to enter a employee ID to update information
     * displays a menu that contains which fields can be updated
     * according to choice provokes related method from manager class
     * also checks test conditions
     * @author Sezai Araplarlı
     */
    private void updateEmployeeNonProfile(Scanner scanner) {
        System.out.print("Enter the employee ID to update: ");
        if (scanner.hasNextInt()) {
            int employeeId = scanner.nextInt();
            scanner.nextLine();
    
            
            System.out.println("Select the field to update:");
            System.out.println("1. Name");
            System.out.println("2. Surname");
            System.out.println("3. Role");
            System.out.print("Enter your choice: ");
    
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                String newValue;
    
                switch (choice) {
                    case 1:
                        System.out.print("Enter new name: ");
                        newValue = scanner.nextLine();
                        manager.updateEmployeeNonProfile(employeeId, newValue, null, null);
                        break;
                    case 2:
                        System.out.print("Enter new surname: ");
                        newValue = scanner.nextLine();
                        manager.updateEmployeeNonProfile(employeeId, null, newValue, null);
                        break;
                    case 3:
                        System.out.print("Enter new role (manager, technician, intern, engineer): ");
                        newValue = scanner.nextLine();
                        if (!newValue.matches("(?i)manager|technician|intern|engineer")) {
                            System.out.println("Invalid role. Allowed roles: manager, technician, intern, engineer.");
                            return;
                        }
                        manager.updateEmployeeNonProfile(employeeId, null, null, newValue);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        } else {
            System.out.println("Invalid input. Please enter a valid employee ID.");
            scanner.nextLine();
}
}
    
    /**
     * gets new employee's profile and non-profile fields and provokes hire employee method from manager class
     * 
     * @author Sezai Araplarlı
     * @author Emir Esad Şahin
     */
    private void hireNewEmployee(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
    
        System.out.print("Enter role (manager, technician, intern, engineer): ");
        String role = scanner.nextLine();
    
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
    
        System.out.print("Enter phone number : ");
        String phone = scanner.nextLine();
    
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
    
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
    
        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();
    
        Utils.clearConsole();
        manager.hireEmployee(username, role, name, surname, phone, email, dob, startDate);
    }
    
    /**
     * get an input from user to fire user with employee ID
     * checks if input ID is same with himself/herself so that the manager cannot fire himself/herself
     * @author Emir Esad Şahin
     * @author Sezai Araplarlı
     */
    private void fireEmployee(Scanner scanner) {
        System.out.print("Enter the employee ID to fire: ");
        if (scanner.hasNextInt()) {
            int employeeId = scanner.nextInt();
            scanner.nextLine(); 
    
            
            if (employeeId == manager.getE_id()) {
                System.out.println("Error: You cannot fire yourself!");
                return;
            }
    
            try {
                manager.fireEmployee(employeeId);
            } catch (Exception e) {
                System.out.println("Error while firing employee: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid input. Please enter a valid employee ID.");
            scanner.nextLine();
        }
    }
    
    
    
    /**
     * display a little menu to manager
     * and manager choose between operations to update own profile
     * according to selection provokes related methods from manager class
     * @author Sezai Araplarlı
     */
    private void updateOwnProfile(Scanner scanner) {
        while (true) {
            System.out.println("\n=== UPDATE OWN PROFILE ===");
            System.out.println("1. Update Password");
            System.out.println("2. Update Phone Number");
            System.out.println("3. Update Email");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
    
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
    
                switch (choice) {
                    case 1:
                        
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        try {
                            manager.updateOwnProfile(newPassword, manager.getPhoneNumber(), manager.getEmail());
                            Utils.clearConsole();
                            System.out.println("Password updated successfully.");
                        } catch (Exception e) {
                            Utils.clearConsole();
                            System.out.println("Error updating password: " + e.getMessage());
                        }
                        break;
    
                    case 2:
                        
                        while (true) {
                            System.out.print("Enter new phone number : ");
                            String newPhone = scanner.nextLine();
                            if (newPhone.matches("\\d{10,15}")) {
                                try {
                                    manager.updateOwnProfile(manager.getPassword(), newPhone, manager.getEmail());
                                    Utils.clearConsole();
                                    System.out.println("Phone number updated successfully.");
                                    break;
                                } catch (Exception e) {
                                    Utils.clearConsole();
                                    System.out.println("Error updating phone number: " + e.getMessage());
                                    break;
                                }
                            } else {
                                System.out.println("Invalid phone number. Please enter 11 digits.");
                            }
                        }
                        break;
    
                    case 3:
                        
                        while (true) {
                            System.out.print("Enter new email address: ");
                            String newEmail = scanner.nextLine();
                            if (newEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                                try {
                                    manager.updateOwnProfile(manager.getPassword(), manager.getPhoneNumber(), newEmail);
                                    Utils.clearConsole();
                                    System.out.println("Email updated successfully.");
                                    break;
                                } catch (Exception e) {
                                    Utils.clearConsole();
                                    System.out.println("Error updating email: " + e.getMessage());
                                    break;
                                }
                            } else {
                                System.out.println("Invalid email address. Please enter a valid email (e.g., example@example.com).");
                            }
                        }
                        break;
    
                    case 4:
                        // Back to main menu
                        Utils.clearConsole();
                        return;
    
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1-4).");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    
    
    
    
    /**
     * input dataset size from user
     * generate a dataset with input size (provokes algorithm class)
     * sequentially starts algorithms by calling them from algorithm class
     * at the end compares the sorting results of these 4 algorithms with java's collection sort to make sure algorithms work correctly 
     * @param startTime start time for the algorithm 
     * @param endTime   end time for the algorithm so we can substract these variables to find execution time
     * @author Tunahan Tuze
     * @author Dilvin Aydın
     * @author Zülal Sönmez
     */
    private void runSortingAlgorithms(Scanner scanner) {
        System.out.print("Enter the dataset size (between 1000 and 10000): ");
        if (scanner.hasNextInt()) {
            int size = scanner.nextInt();
            scanner.nextLine();
            
            if (size < 1000 || size > 10000) {
                System.out.println("Invalid size. Must be between 1000 and 10000.");
                return;
            }
            
            int[] dataset = Algorithms.generateDataset(size);
            System.out.println("Dataset generated!");
            
            long startTime, endTime;
            
            // Radix Sort
            int[] radixData = dataset.clone();
            startTime = System.nanoTime();
            radixData = Algorithms.radixSort(radixData); // Sonuç atanıyor
            endTime = System.nanoTime();
            long RadixExecutionTime = endTime - startTime;
            
            // Shell Sort
            int[] shellData = dataset.clone();
            startTime = System.nanoTime();
            shellData = Algorithms.shellSort(shellData); // Sonuç atanıyor
            endTime = System.nanoTime();
            long shellExecutionTime = endTime - startTime;
            
            // Heap Sort
            int[] heapData = dataset.clone();
            startTime = System.nanoTime();
            heapData = Algorithms.heapSort(heapData); // Sonuç atanıyor
            endTime = System.nanoTime();
            long HeapExecutionTime = endTime - startTime;
            
            // Insertion Sort
            int[] insertionData = dataset.clone();
            startTime = System.nanoTime();
            insertionData = Algorithms.insertionSort(insertionData); // Sonuç atanıyor
            endTime = System.nanoTime();
            long insertionExecutionTime = endTime - startTime;
            
            // Collections.sort() for comparison
            int[] collectionsData = dataset.clone();
            startTime = System.nanoTime();
            Arrays.sort(collectionsData);
            endTime = System.nanoTime();
        
            
    
            // Verify correctness
            boolean isEqualShell = Arrays.equals(shellData, collectionsData);
            boolean isEqualInsertionforinsertion = Arrays.equals(insertionData, collectionsData);
            boolean isEqualRadix = Arrays.equals(radixData, collectionsData);
            boolean isEqualHeap = Arrays.equals(heapData, collectionsData);
            
            // Styled Output
            String red = "\033[31m";
            String greenBold = "\033[1;32m";
            String yellow = "\033[33m";
            String blue = "\033[34m";
            String reset = "\033[0m";
            
            System.out.println(red + "-     Algorithms Name   ---      Duration (ns)     -" + reset);
            System.out.println(greenBold + "|-----------------------|-------------------------|" + reset);
            System.out.println(greenBold + "|" + blue + "    Shell Sort         " + greenBold + "|        " + yellow + shellExecutionTime + " ns" + reset);
            System.out.println(greenBold + "|-----------------------|-------------------------|" + reset);
            System.out.println(greenBold + "|" + blue + "    Insertion Sort     " + greenBold + "|        " + yellow + insertionExecutionTime + " ns" + reset);
            System.out.println(greenBold + "|-----------------------|-------------------------|" + reset);
            System.out.println(greenBold + "|" + blue + "    Radix Sort         " + greenBold + "|        " + yellow + RadixExecutionTime + " ns" + reset);
            System.out.println(greenBold + "|-----------------------|-------------------------|" + reset);
            System.out.println(greenBold + "|" + blue + "    Heap Sort          " + greenBold + "|        " + yellow + HeapExecutionTime + " ns" + reset);
            System.out.println(greenBold + "|-----------------------|-------------------------|" + reset);
            
            System.out.println();
            System.out.println(blue + "Shell Sort is equal to Collections.sort: " + yellow + isEqualShell + reset);
            System.out.println(yellow + "Insertion Sort is equal to Collections.sort: " + blue + isEqualInsertionforinsertion + reset);
            System.out.println(blue + "Radix Sort is equal to Collections.sort: " + yellow + isEqualRadix + reset);
            System.out.println(yellow + "Heap Sort is equal to Collections.sort: " + blue + isEqualHeap + reset);
            System.out.println();
            
        }
    
    }
}
