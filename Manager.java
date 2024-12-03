import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.UnsupportedEncodingException;

public class Manager extends Employee {
    public Manager(int e_id, String username, String password, String role, String name,
                   String surname, String phoneNumber, String dateOfBirth, String dateOfStart, String email) {
        super(e_id, username, password, role, name, surname, phoneNumber, dateOfBirth, dateOfStart, email);
    }
    // Kullanıcıdan alınan veriyi UTF-8 formatına dönüştürme
    public String convertToUTF8(String input) {
        try {
            byte[] bytes = input.getBytes("UTF-8");
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error converting to UTF-8: " + e.getMessage());
            return input; // Eğer hata olursa, orijinal veriyi döndür
        }
    }
    

    @Override
    public void displayProfile() {
        System.out.println("\n=== MANAGER PROFILE ===");
        System.out.println("Name: " + getName() + " " + getSurname());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
    }

    public void updateOwnProfile(String newPassword, String newPhone, String newEmail) {
        if (!newPhone.matches("\\d{11}")) {
            System.out.println("Invalid phone number. It must be 11 digits.");
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
    
    

    public void displayEmployeeByUsername(String username) {
        // Kullanıcıdan alınan username'i UTF-8 formatına dönüştürme
        username = convertToUTF8(username);
    
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "SELECT e_id, name, surname, phone_number, email, role FROM employees WHERE username COLLATE utf8mb4_general_ci = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username); // Kullanıcı adı parametresi olarak sorguya ekleniyor
            
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
    
    
    
    

    public void updateEmployeeNonProfile(int e_id, String name, String surname, String role) {
        // Role doğrulaması
        if (role != null && !role.matches("(?i)manager|technician|intern|engineer")) {
            System.out.println("Invalid role. Allowed roles: manager, technician, intern, engineer.");
            return;
        }
    
        try (Connection conn = DatabaseFacade.getConnection()) {
            String query = "UPDATE employees SET name = ?, surname = ?, role = ? WHERE e_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
    
            // Null değerler için önceki değeri koruyarak güncelleme
            stmt.setString(1, name != null && !name.isEmpty() ? name : null);
            stmt.setString(2, surname != null && !surname.isEmpty() ? surname : null);
            stmt.setString(3, role != null && !role.isEmpty() ? role : null);
            stmt.setInt(4, e_id);
    
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
    

    public void hireEmployee(String username, String password, String role, String name, String surname, String phone, String email, String dob, String startDate) {
        try {
            // Role doğrulama
            if (!role.matches("(?i)manager|technician|intern|engineer")) {
                System.out.println("Invalid role. Allowed roles: manager, technician, intern, engineer.");
                return;
            }
    
            // Telefon doğrulama
            if (!isValidPhone(phone)) {
                System.out.println("Invalid phone number. Please enter a valid 11-digit number.");
                return;
            }
    
            // E-posta doğrulama
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email.");
                return;
            }
    
            // Tarih doğrulama
            if (!isValidDate(dob) || !isValidDate(startDate)) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                return;
            }
    
            // Doğum tarihi işe başlama tarihinden önce mi kontrol et
            if (!isBirthDateBeforeStartDate(dob, startDate)) {
                System.out.println("Date of birth cannot be greater than or equal to start date.");
                return;
            }
    
            try (Connection conn = DatabaseFacade.getConnection()) {
                String query = "INSERT INTO employees (username, password, role, name, surname, phone_number, email, dateofbirth, dateofstart) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, role);
                stmt.setString(4, name);
                stmt.setString(5, surname);
                stmt.setString(6, phone);
                stmt.setString(7, email);
                stmt.setString(8, dob);
                stmt.setString(9, startDate);
    
                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Employee hired successfully.");
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
    
    // Yardımcı doğrulama metotları
    private boolean isValidPhone(String phone) {
        return phone.matches("^\\d{11}$");
    }
    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
    
    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Tarih doğruluğunu sıkı bir şekilde kontrol eder
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            System.out.println("Invalid date. Please provide a valid calendar date (e.g., 2023-12-01).");
            return false;
        }
    }
    
    
    private boolean isBirthDateBeforeStartDate(String dob, String startDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dob).before(sdf.parse(startDate));
        } catch (ParseException e) {
            return false;
        }
    }
    
    
    

    public void fireEmployee(int employeeId) {
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