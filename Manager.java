import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Manager class for Manager.
 * It extends from Employee
 * 
 * @author Emir Esad Sahin
 * @author Sezai Araplarlı
 */
public class Manager extends Employee {
    public Manager(int e_id, String username, String password, String role, String name,
                   String surname, String phoneNumber, String dateOfBirth, String dateOfStart, String email) {
        super(e_id, username, password, role, name, surname, phoneNumber, dateOfBirth, dateOfStart, email);
    }

    
        /**
         * DisplayProfile displays profile information.
         * 
         * @author Emir Esad Sahin
         */
    @Override
    public void displayProfile() {
        System.out.println("\n=== MANAGER PROFILE ===");
        System.out.println("Name: " + getName() + " " + getSurname());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
    }
        /**
         * updateOwnProfile updates profile information.
         * Checks regex for phone number and email
         * @param newPassword   updated password
         * @param newPhone updated phone number
         * @param newEmail updated email
         * @author Emir Esad Sahin
         */
    public void updateOwnProfile(String newPassword, String newPhone, String newEmail) {
        if (!newPhone.matches("\\d{10,15}")) {
            System.out.println("Invalid phone number.");
            return;
        }
        if (!newEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("Invalid email address. Please enter a valid email (e.g., example@example.com).");
            return;
        }
    
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "UPDATE employees SET password = ?, phone_number = ?, email = ? WHERE e_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newPassword);
            stmt.setString(2, newPhone);
            stmt.setString(3, newEmail);
            stmt.setInt(4, getE_id());
    
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Profile updated successfully.");
            } else {
                System.out.println("Failed to update profile. Please try again.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating profile: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    
    
    /** 
     * displayAllEmployees displays all employees and their informations without password from database
     * with table format
     * @author Emir Esad Sahin
     */
    public void displayAllEmployees() {
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "SELECT * FROM employees";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
    
            System.out.println("\n=== ALL EMPLOYEES ===");
            System.out.println(String.format("%-5s %-15s %-15s %-15s %-15s %-15s %-30s", 
                "ID", "Username", "Role", "Name", "Surname", "Phone", "Email"));
            System.out.println(String.format("%-5s %-15s %-15s %-15s %-15s %-15s %-30s", 
                "-----", "---------------", "---------------", "---------------", "---------------", "---------------", "------------------------------"));
    
            while (rs.next()) {
                System.out.println(String.format("%-5d %-15s %-15s %-15s %-15s %-15s %-30s",
                    rs.getInt("e_id"),
                    rs.getString("username"),
                    rs.getString("role"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("phone_number"),
                    rs.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying employees: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    
    
    /**
     * displayEmployeesWithRole displays employees role by role from database
     * Roles are engineer, manager, intern and technician
     * @param role role of employee
     * @author Emir Esad Sahin
     */
    public void displayEmployeesWithRole(String role) {
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "SELECT * FROM employees WHERE role = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, role);
            ResultSet rs = stmt.executeQuery();
    
            System.out.println("\n=== EMPLOYEES WITH ROLE: " + role.toUpperCase() + " ===");
            System.out.println(String.format("%-5s %-15s %-15s", "ID", "Name", "Surname"));
            System.out.println(String.format("%-5s %-15s %-15s", "-----", "---------------", "---------------"));
    
            while (rs.next()) {
                System.out.println(String.format("%-5d %-15s %-15s",
                        rs.getInt("e_id"),
                        rs.getString("name"),
                        rs.getString("surname")));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying employees with role: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    
    
    /**
     * displayEmployeeByUsername displays employees informations using username from database
     * @param username username of employee
     * @author Emir Esad Sahin
     */
    public void displayEmployeeByUsername(String username) {


    
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "SELECT e_id, name, surname, phone_number, email, role FROM employees WHERE username COLLATE utf8mb4_general_ci = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username); 
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("\n=== EMPLOYEE DETAILS ===");
                System.out.println(String.format("%-10s %-20s %-15s %-30s %-15s", 
                    "ID", "Name", "Phone", "Email", "Role"));
                System.out.println(String.format("%-10s %-20s %-15s %-30s %-15s", 
                    "----------", "--------------------", "---------------", "------------------------------", "---------------"));

                System.out.println(String.format("%-10d %-20s %-15s %-30s %-15s", 
                    rs.getInt("e_id"),
                    rs.getString("name") + " " + rs.getString("surname"),
                    rs.getString("phone_number"),
                    rs.getString("email"),
                    rs.getString("role")));

            } else {
                System.out.println("Employee not found. Please check the username and try again.");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching employee details: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    
    
    
    
    /**
     * updateEmployeeNonProfile updates non profile informations in database
     * These are name, surname and role
     * These informations cannot empty. 
     * @param e_id employee id
     * @param name emplyee name
     * @param surname employee surname
     * @param role employee role
     * @author Emir Esad Sahin
     */
    public void updateEmployeeNonProfile(int e_id, String name, String surname, String role) {
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "UPDATE employees SET " +
                    (name != null ? "name = ?," : "") +
                    (surname != null ? "surname = ?," : "") +
                    (role != null ? "role = ?," : "");
            
            if (query.endsWith(",")) {
                query = query.substring(0, query.length() - 1); 
            }
            query += " WHERE e_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
    
            int parameterIndex = 1;
            if (name != null) {
                stmt.setString(parameterIndex++, name);
            }
            if (surname != null) {
                stmt.setString(parameterIndex++, surname);
            }
            if (role != null) {
                stmt.setString(parameterIndex++, role);
            }
            stmt.setInt(parameterIndex, e_id);
    
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("No employee found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
}
}
    
    /**
     * hireEmployee adds new employee with non profile and profile informations in database
     * These are username, password, role, name, surname, phone number, email, date of birth and date of start
     * These informations cannot empty. 
     * @param username employe username
     * @param role employee role
     * @param name employee name
     * @param surname employee surname
     * @param phone employee phone number
     * @param email employee email
     * @param dob is date of birth
     * @param startDate is date of start
     * @author Emir Esad Sahin
     */
    public void hireEmployee(String username, String role, String name, String surname, String phone, String email, String dob, String startDate) {
        String defaultPassword = "defaultpassword"; 
    
        try {

            if (username == null || username.trim().isEmpty() ||
                role == null || role.trim().isEmpty() ||
                name == null || name.trim().isEmpty() ||
                surname == null || surname.trim().isEmpty() ||
                phone == null || phone.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                dob == null || dob.trim().isEmpty() ||
                startDate == null || startDate.trim().isEmpty()) {
                System.out.println("All fields are required. Please ensure no field is left empty.");
                return;
            }
    

            if (!role.matches("(?i)manager|technician|intern|engineer")) {
                System.out.println("Invalid role. Allowed roles: manager, technician, intern, engineer.");
                return;
            }
    

            if (!isValidPhone(phone)) {
                System.out.println("Invalid phone number. Please enter a valid 11-digit number.");
                return;
            }

            
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email.");
                return;
            }
    

            if (!isValidDate(dob)) {
                System.out.println("Invalid date format for Date of Birth. Please use YYYY-MM-DD.");
                return;
            }
    
            if (!isValidDate(startDate)) {
                System.out.println("Invalid date format for Start Date. Please use YYYY-MM-DD.");
                return;
            }
    

            if (!isDateBeforeToday(dob)) {
                System.out.println("Date of Birth cannot be in the future.");
                return;
            }
    
            if (!isDateBeforeToday(startDate)) {
                System.out.println("Start Date cannot be in the future.");
                return;
            }
    

            if (!isBirthDateBeforeStartDate(dob, startDate)) {
                System.out.println("Date of Birth cannot be greater than or equal to Start Date, and the employee must be at least 18 years old.");
                return;
            }
    

            try (Connection conn = DatabaseFacade.getConnection()) {
                String query = "INSERT INTO employees (username, password, role, name, surname, phone_number, email, dateofbirth, dateofstart) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, defaultPassword); 
                stmt.setString(3, role);
                stmt.setString(4, name);
                stmt.setString(5, surname);
                stmt.setString(6, phone);
                stmt.setString(7, email);
                stmt.setString(8, dob);
                stmt.setString(9, startDate);
    
                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Employee hired successfully with default password.");
                } else {
                    System.out.println("Error hiring employee.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error inserting employee: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    

    
    
    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10,15}");
    }
    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
    
    private boolean isValidDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return false;
        } catch (Exception e) {
            System.out.println("Unexpected error while parsing the date: " + e.getMessage());
            return false;
        }
    }
    

    private boolean isDateBeforeToday(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate inputDate = LocalDate.parse(date, formatter);
            LocalDate today = LocalDate.now();
            return !inputDate.isAfter(today);
        } catch (DateTimeParseException e) {
            return false;
        }
    } 
    
    private boolean isBirthDateBeforeStartDate(String dob, String startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate birthDate = LocalDate.parse(dob, formatter);
            LocalDate startWorkDate = LocalDate.parse(startDate, formatter);
    
            
            return birthDate.isBefore(startWorkDate) && birthDate.plusYears(18).isBefore(startWorkDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public void fireEmployee(int employeeId) {
        if (employeeId == getE_id()) {
            System.out.println("Error: You cannot fire yourself!");
            return;
        }
    
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "DELETE FROM employees WHERE e_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, employeeId);
    
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee fired successfully.");
            } else {
                System.out.println("No employee found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    
    
    
}