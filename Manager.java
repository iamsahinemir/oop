//import java.time.LocalDate;


public class Manager extends Employee {

    
    public Manager(int employeeId, String username, String password,
                  String name, String surname, String phoneNumber, String email){

        super(employeeId, username, password, "Manager", name, surname, phoneNumber, email);
        
    }


    
    public void updateOwnProfile(String updatedEmail, String updatedPassword, String updatedPhoneNumber){

        setEmail(updatedEmail);
        setPassword(updatedPassword);
        setPhoneNumber(updatedPhoneNumber);
    }  
       

    // Tüm çalışanları listeleme
    public void displayAllEmployees() {
        
    }

    //Rol bazlı çalışanları listeleme
    public void displayEmployeesByRole(String role) {
        
    }

    // Çalışan non-profile bilgilerini güncelleme
    public void updateEmployeeNonProfile() {
        
    }

    // Çalışan Ekleme
    public void hireEmployee() {

    }

    // Çalışan Silme            //employeeID'sine göre ulaşıp oradan silmek mantıklı
    public void fireEmployee() {
    
    }

    // Algoritma İşlemlerini Çağırma
    public void Algorithms() {
        
    }

    public static void main(String[] args) {
        
        Manager manager1 = new Manager(123456, "sezowastaken", "951753"
        , "Sezai", "Araplarlı",
        "+90 533 791 83 37", "sezowastaken@hotmail.com");

        manager1.displayProfile();
        System.out.println("------------------------------------");
        manager1.updateOwnProfile("sezowastaken@stu.khas.edu.tr", "123456", "+90 531 684 90 90");
        manager1.displayProfile();
        manager1.displayNonProfile();
    }

    

}