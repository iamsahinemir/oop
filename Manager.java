//import java.time.LocalDate;

import java.time.LocalDate;
import java.util.Scanner;

public class Manager extends RegularEmployee {

    
    public Manager(int employeeId, String username, String password,
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
        
        EmployeeDAO dao = new EmployeeDAO();
        System.out.print("Enter username: ");
        String username = input.nextLine();
        dao.displayEmployee(username);
        
    }

    //Rol bazlı çalışanları listeleme
    public void displayEmployeesByRole(String role) {
        
    }

    // Çalışan non-profile bilgilerini güncelleme
    public void updateEmployeeNonProfile() {
        
    }

    // Çalışan Ekleme
    public void hireEmployee() {
        
        EmployeeDAO dao = new EmployeeDAO();
        System.out.print("Enter username: ");
        username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        System.out.print("Enter role (manager/engineer/technician/intern): ");
        String role = input.nextLine();
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter surname: ");
        String surname = input.nextLine();
        dao.addEmployee(username, password, role, name, surname);

    }

    // Çalışan Silme            //employeeID'sine göre ulaşıp oradan silmek mantıklı
    public void fireEmployee() {
    
    }

    // Algoritma İşlemlerini Çağırma
    public void Algorithms() {
        
    }

    

    public static void main(String[] args) {

        DatabaseFacade dbFacade = new DatabaseFacade();
        
        RegularEmployee employee = dbFacade.getRegularEmployeeByUsername("iamsahinemir");
        RegularEmployee employee2 = dbFacade.getRegularEmployeeByUsername("sezowastaken");
        /*
        Employee employee1 = new Employee(123456, "sezowastaken", "951753",
        "Technician", "Sezai", "Araplarlı",
        "+90 533 791 83 37", "sezowastaken@hotmail.com");

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
        
        employee.displayProfile();
        employee2.displayProfile();

    }

    
    
}