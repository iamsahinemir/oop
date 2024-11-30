import java.time.LocalDate;

public class RegularEmployee extends Employee {
    
    public RegularEmployee(int employeeId, String username, String password, String role, String name, 
                           String surname, String phoneNo, String dateOfBirth, String dateOfStart, String email) {
        super(employeeId, username, password, role, name, surname, phoneNo, dateOfBirth, dateOfStart, email);
    }

    @Override
    public void displayProfile() {
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

    @Override
    public void displayNonProfile() {

    }
}
