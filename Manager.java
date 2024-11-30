import java.util.Scanner;

public class Manager extends RegularEmployee {

    
    public Manager(int employeeId, String username, String password, String role,
                  String name, String surname, String phoneNumber, String dateOfBirth, String dateOfStart, String email){

        super(employeeId, username, password, "Manager", name, surname, phoneNumber, dateOfBirth, dateOfStart, email);
        
    }

    Scanner input = new Scanner(System.in);


    
    public void updateOwnProfile(String updatedEmail, String updatedPassword, String updatedPhoneNumber){

        setEmail(updatedEmail);
        setPassword(updatedPassword);
        setPhoneNumber(updatedPhoneNumber);
    }
       

    // Tüm çalışanları listeleme
    public void displayAllEmployees() {
        
        
    }

    public void displayEmployeesByUsername(){

        System.out.println("----- Regular Employee Proile ----");
        System.out.println("Username: "+ getUsername());
        System.out.println("Name: " + getName());
        System.out.println("Surname: "+ getSurname());
        System.out.println("Role: "+ getRole());
        System.out.println("Phone Number: "+ getPhoneNumber());
        System.out.println("Date of Birth: "+ getDateOfBirth());
        System.out.println("Date of Start: "+ getDateOfStart());
        System.out.println("Email: "+ getEmail());

    }

    //Rol bazlı çalışanları listeleme
    public void displayEmployeesByRole(String role) {
        
        System.out.println("----- Regular Employee Proile ----");
        System.out.println("Username: "+ getUsername());
        System.out.println("Name: " + getName());
        System.out.println("Surname: "+ getSurname());
        System.out.println("Role: "+ getRole());
        System.out.println("Phone Number: "+ getPhoneNumber());
        System.out.println("Date of Birth: "+ getDateOfBirth());
        System.out.println("Date of Start: "+ getDateOfStart());
        System.out.println("Email: "+ getEmail());
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

        DatabaseFacade dbFacade = new DatabaseFacade();



        Manager manager3 = dbFacade.getRegularEmployeeByUsername("sezowastaken");
        /*
        Manager employee1 = new Manager(123456, "sezowastaken", "951753",
        "Technician", "Sezai", "Araplarlı",
        "+90 533 791 83 37", "", "sezowastaken@hotmail.com");
        
        //manager1.displayProfile();
        
        //manager1.updateOwnProfile("sezowastaken@stu.khas.edu.tr", "123456", "+90 531 684 90 90");

        employee1.displayNonProfile();
        System.out.println("------------------------------------");
        employee1.setRole("Engineer");
        employee1.displayNonProfile();
        System.out.println("------------------------------------");
        manager1.displayNonProfile();

        */

        //manager1.hireEmployee();
        
        manager3.displayEmployeesByUsername();

    }

    
    
}