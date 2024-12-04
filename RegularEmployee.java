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
            // Validating phone number
            if (!isValidPhoneNumber(newPhoneNumber)) {
                System.out.println("Invalid phone number. Please ensure it contains only numbers and is 11 digits long.");
                return;
            }

            // Validating email
            if (!isValidEmail(newEmail)) {
                System.out.println("Invalid email address. Please provide a valid email (e.g., example@example.com).");
                return;
            }

            setPassword(newPassword);
            setPhoneNumber(newPhoneNumber);
            setEmail(newEmail);
            System.out.println("Profile updated successfully.");

            // Veritabanına güncelleme işlemi
            try (Connection conn = DatabaseFacade.getConnection()) {
                String query = "UPDATE employees SET password = ?, phone_number = ?, email = ? WHERE e_id = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, newPassword != null ? newPassword : getPassword());
                stmt.setString(2, newPhoneNumber != null ? newPhoneNumber : getPhoneNumber());
                stmt.setString(3, newEmail != null ? newEmail : getEmail());
                stmt.setInt(4, getE_id());

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Profile updated successfully in database.");
                } else {
                    System.out.println("Failed to update profile in database.");
                }
            } catch (SQLException e) {
                System.out.println("Error updating profile in database: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error updating profile: " + e.getMessage());
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
