public class RegularEmployee extends Employee {
    
    public RegularEmployee(int employeeId, String username, String password, String role, String name, 
                           String surname, String phoneNo, String dateOfBirth, String dateOfStart, String email) {
        super(employeeId, username, password, role, name, surname, phoneNo, dateOfBirth, dateOfStart, email);
    }

    @Override
    public void displayProfile() {
        


    }

    @Override
    public void displayNonProfile() {

    }
}
