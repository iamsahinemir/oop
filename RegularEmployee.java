import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEmployee extends Employee {

    public RegularEmployee(int e_id, String username, String password, String role, String name,
                           String surname, String phoneNumber, String dateOfBirth, String dateOfStart, String email) {
        super(e_id, username, password, role, name, surname, phoneNumber, dateOfBirth, dateOfStart, email);
    }

    @Override // bak
    public void displayProfile() {
        System.out.println("\n=== EMPLOYEE PROFILE ===");
        System.out.println(String.format("%-20s : %s", "Name", getName()));
        System.out.println(String.format("%-20s : %s", "Surname", getSurname()));
        System.out.println(String.format("%-20s : %s", "Phone", getPhoneNumber()));
        System.out.println(String.format("%-20s : %s", "Email", getEmail()));
        System.out.println(String.format("%-20s : %s", "Date of Birth", getDateOfBirth()));
        System.out.println(String.format("%-20s : %s", "Date of Start", getDateOfStart()));
    }
    

    public void updateProfile(String newPassword, String newPhoneNumber, String newEmail) {
        try {
            // Validating inputs
            if (newPhoneNumber != null && !isValidPhoneNumber(newPhoneNumber)) {
                System.out.println("Invalid phone number. Please ensure it contains only numbers and is 11 digits long.");
                return;
            }
    
            if (newEmail != null && !isValidEmail(newEmail)) {
                System.out.println("Invalid email address. Please provide a valid email (e.g., example@example.com).");
                return;
            }
    
            // Güncellemeleri yapmadan önce null olmayan değerlerle kontrol
            if (newPassword != null) {
                setPassword(newPassword);
            }
            if (newPhoneNumber != null) {
                setPhoneNumber(newPhoneNumber);
            }
            if (newEmail != null) {
                setEmail(newEmail);
            }
    
            // Dinamik SQL Sorgusu Hazırlama
            StringBuilder queryBuilder = new StringBuilder("UPDATE employees SET ");
            boolean isFirst = true;
    
            if (newPassword != null) {
                queryBuilder.append("password = ?");
                isFirst = false;
            }
            if (newPhoneNumber != null) {
                if (!isFirst) queryBuilder.append(", ");
                queryBuilder.append("phone_number = ?");
                isFirst = false;
            }
            if (newEmail != null) {
                if (!isFirst) queryBuilder.append(", ");
                queryBuilder.append("email = ?");
            }
            queryBuilder.append(" WHERE e_id = ?");
    
            // Veritabanı güncellemesi
            try (Connection conn = DatabaseFacade.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(queryBuilder.toString())) {
    
                int paramIndex = 1;
                if (newPassword != null) {
                    stmt.setString(paramIndex++, newPassword);
                }
                if (newPhoneNumber != null) {
                    stmt.setString(paramIndex++, newPhoneNumber);
                }
                if (newEmail != null) {
                    stmt.setString(paramIndex++, newEmail);
                }
                stmt.setInt(paramIndex, getE_id());
    
                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Profile updated successfully in the database.");
                } else {
                    System.out.println("Failed to update profile in the database.");
                }
            } catch (SQLException e) {
                System.out.println("Error updating profile in the database: " + e.getMessage());
            }
    
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    
    // Telefon numarasının geçerli olup olmadığını kontrol eden metod
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Telefon numarası yalnızca 10 veya 11 haneli olmalıdır
        String phoneRegex = "^\\d{10,15}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    // E-posta adresinin geçerli olup olmadığını kontrol eden metod
    private boolean isValidEmail(String email) {
        // Geçerli bir e-posta formatı
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
