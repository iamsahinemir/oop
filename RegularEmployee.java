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

    /**
     * override from abstract employee class
     * to display regular employee's profile
     * @author Emir Esad Şahin
     */
    @Override
    public void displayProfile() {
        System.out.println("\n=== EMPLOYEE PROFILE ===");
        System.out.println(String.format("%-20s : %s", "Name", getName()));
        System.out.println(String.format("%-20s : %s", "Surname", getSurname()));
        System.out.println(String.format("%-20s : %s", "Phone", getPhoneNumber()));
        System.out.println(String.format("%-20s : %s", "Email", getEmail()));
        System.out.println(String.format("%-20s : %s", "Date of Birth", getDateOfBirth()));
        System.out.println(String.format("%-20s : %s", "Date of Start", getDateOfStart()));
    }
    

    /**
     * checks the entered input first
     * then it sets password, phone number and email in database to newly entered inputs
     * @param newPassword       entered password to be updated
     * @param newPhoneNumber    entered phone number to be updated
     * @param newEmail          entered email to be updated 
     * @author Emir Esad Şahin
     */
    public void updateProfile(String newPassword, String newPhoneNumber, String newEmail) {
        try {

            if (newPhoneNumber != null && !isValidPhoneNumber(newPhoneNumber)) {
                System.out.println("Invalid phone number. Please ensure it contains only numbers and is 11 digits long.");
                return;
            }
    
            if (newEmail != null && !isValidEmail(newEmail)) {
                System.out.println("Invalid email address. Please provide a valid email (e.g., example@example.com).");
                return;
            }
    
            if (newPassword != null) {
                setPassword(newPassword);
            }
            if (newPhoneNumber != null) {
                setPhoneNumber(newPhoneNumber);
            }
            if (newEmail != null) {
                setEmail(newEmail);
            }
    
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

    /**
     * a regex to format phone number between 10 and 15 digits
     * @param phoneNumber
     * @return it means that the parameter and the pattern matches so it returns true
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        
        String phoneRegex = "^\\d{10,15}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    /**
     * a regex to format email type blabla@blabla.bla
     * @param email entered email from regular employee to update own profile
     * @return it means that the parameter and the pattern matches so it returns true
     */
    private boolean isValidEmail(String email) {
        
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
