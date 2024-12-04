import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class ManagerMenu {
    private Manager manager;

    public ManagerMenu(Manager manager) {
        this.manager = manager;
    }
    
    public void displayMenu() {
        String reset = "\u001B[0m";          // Varsayılan renk
        String greenBold = "\033[1;32m";    // Kalın Yeşil
        String blue = "\033[34m";           // Mavi
        String cyan = "\033[36m";           // Camgöbeği
        String purple = "\033[35m";         // Mor
        String yellow = "\033[33m";         // Sarı
        String red = "\033[31m";            // Kırmızı
        String blueBold = "\033[1;34m";     // Kalın Mavi
        String magenta = "\033[35m";        // Magenta
        String cyanBold = "\033[1;36m";     // Kalın Camgöbeği
        String whiteBold = "\033[1;37m";    // Kalın Beyaz
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(greenBold + "\n=== MANAGER MENU ===" + reset);
            System.out.println(blue + "1. Display All Employees" + reset);
            System.out.println(cyan + "2. Display Employees by Role" + reset);
            System.out.println(purple + "3. Display Employee by Username" + reset);
            System.out.println(yellow + "4. Update Employee Non-Profile Fields" + reset);
            System.out.println(red + "5. Hire New Employee" + reset);
            System.out.println(greenBold + "6. Fire Employee" + reset);
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
                        Utils.clearConsole(); // Clear the console
                        Main.main(new String[]{}); // Call the Main class's main method
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1-9).");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private void displayEmployeesByRole(Scanner scanner) {
        System.out.print("Enter role (e.g., technician, engineer, intern, manager): ");
        String role = scanner.nextLine();
    
        // Geçerli rollerin listesi
        String[] validRoles = {"technician", "engineer", "intern", "manager"};
    
        // Kullanıcı girişinin doğrulanması
        boolean isValidRole = Arrays.stream(validRoles)
                                    .anyMatch(validRole -> validRole.equalsIgnoreCase(role));
                                    Utils.clearConsole();
        if (!isValidRole) {
            Utils.clearConsole();
            System.out.println("Invalid role. Allowed roles: technician, engineer, intern, manager.");
            return;
        }
    
        // Geçerli bir rol ise veritabanında arama yap
        try {
            manager.displayEmployeesWithRole(role);
        } catch (Exception e) {
            System.out.println("Error displaying employees with the specified role: " + e.getMessage());
        }
    }
    
    

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
    

    private void updateEmployeeNonProfile(Scanner scanner) {
        System.out.print("Enter the employee ID to update: ");
        if (scanner.hasNextInt()) {
            int employeeId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new surname: ");
            String surname = scanner.nextLine();
            System.out.print("Enter new role (manager, technician, intern, engineer): ");
            String role = scanner.nextLine();
    
            if (!role.isEmpty() && !role.matches("(?i)manager|technician|intern|engineer")) {
                Utils.clearConsole();
                System.out.println("Invalid role. Allowed roles: manager, technician, intern, engineer.");
                return;
            }
            Utils.clearConsole();
            manager.updateEmployeeNonProfile(employeeId,
                    name.isEmpty() ? null : name,
                    surname.isEmpty() ? null : surname,
                    role.isEmpty() ? null : role);
        } else {
            Utils.clearConsole();
            System.out.println("Invalid input. Please enter a valid employee ID.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    private void hireNewEmployee(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
    
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    
        System.out.print("Enter role (manager, technician, intern, engineer): ");
        String role = scanner.nextLine();
    
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
    
        System.out.print("Enter phone number (11 digits): ");
        String phone = scanner.nextLine();
    
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
    
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
    
        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();
    
        Utils.clearConsole();
        manager.hireEmployee(username, password, role, name, surname, phone, email, dob, startDate);
    }
    

    private void fireEmployee(Scanner scanner) {
        System.out.print("Enter the employee ID to fire: ");
        if (scanner.hasNextInt()) {
            Utils.clearConsole();
            int employeeId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            try {
                manager.fireEmployee(employeeId);
            } catch (Exception e) {
                Utils.clearConsole();
                System.out.println("Error while firing employee: " + e.getMessage());
            }
        } else {
            Utils.clearConsole();
            System.out.println("Invalid input. Please enter a valid employee ID.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    

    private void updateOwnProfile(Scanner scanner) {
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        
        String newPhone;
        while (true) {
            System.out.print("Enter new phone number (numbers only): ");
            newPhone = scanner.nextLine();
            if (newPhone.matches("\\d+")) { // Telefon numarası sadece sayılar içermelidir
                break;
            } else {
                System.out.println("Invalid phone number. Please enter numbers only.");
            }
        }
    
        String newEmail;
        while (true) {
            System.out.print("Enter new email address: ");
            newEmail = scanner.nextLine();
            if (newEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                break;
            } else {
                System.out.println("Invalid email address. Please enter a valid email (e.g., example@example.com).");
            }
        }
    
        try {
            Utils.clearConsole();
            manager.updateOwnProfile(newPassword, newPhone, newEmail);
        } catch (Exception e) {
            Utils.clearConsole();
            System.out.println("Error updating profile: " + e.getMessage());
        }
    }
    
    
    

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
            long collectionsExecutionTime = endTime - startTime;
            
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
