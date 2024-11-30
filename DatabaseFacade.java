import java.sql.*;

public class DatabaseFacade {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/firm_management_11";
    private static final String USER = "root"; // MySQL kullanıcı adı
    private static final String PASSWORD = ""; // MySQL şifresi

    private Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver yüklenemedi: " + e.getMessage());
        }
    }

    public DatabaseFacade() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
        }
    }

    public RegularEmployee getRegularEmployeeByUsername(String username) {
        String query = "SELECT * FROM employees WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new RegularEmployee(
                    rs.getInt("e_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("phone_number"),
                    rs.getString("dateofbirth"),
                    rs.getString("dateofstart"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println("Çalışan alınırken bir hata oluştu: " + e.getMessage());
        }
        return null;
    }
}