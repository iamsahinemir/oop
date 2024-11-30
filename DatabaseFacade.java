import java.sql.*;

public class DatabaseFacade {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/firm_management_11";
    private static final String USER = "root"; // MySQL kullanıcı adı
    private static final String PASSWORD = ""; // MySQL şifresi

    private Connection connection;

    // JDBC sürücüsünü yüklemek için statik blok
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver yüklenemedi: " + e.getMessage());
        }
    }

    // Veritabanı bağlantısını kurar
    public DatabaseFacade() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
        }
    }

    /**
     * Verilen kullanıcı adına göre bir RegularEmployee nesnesi döndürür.
     *
     * @param username Çalışanın kullanıcı adı.
     * @return RegularEmployee nesnesi veya null.
     */
    public Manager getRegularEmployeeByUsername(String username) {
        
        String query = "SELECT * FROM employees WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                // RegularEmployee nesnesini oluştur ve döndür
                return new Manager(
                    rs.getInt("e_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("phone_number"),
                    rs.getString("dateOfBirth"),
                    rs.getString("dateOfStart"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println("Çalışan alınırken bir hata oluştu: " + e.getMessage());
        }
        return null;
    }

    public void displayEmployeesByRole(String role) {
        /*          !!!!!DEĞİEŞECEK!!!!!!!!1
        try (Connection conn = DatabaseUtils.getConnection()) {
            String query = "SELECT * FROM employees WHERE role = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, role);
            ResultSet rs = stmt.executeQuery();
    
            System.out.println("ID | Name | Surname | Role");
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %s%n",
                        rs.getInt("employee_id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("role"));
            }
        } catch (Exception e) {
            System.out.println("Error displaying employees by role: " + e.getMessage());
        }
             */
    }
    


}
