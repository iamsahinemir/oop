
public class Employee {

    private int employeeId;      //şimdilik kullanılmıyor
    private String username;
    private String password;
    private String role;           //role için sadece 4 rolden biri olabilecek şekilde bir ayarlama çözmemiz lazım
    private String name;
    private String surname;
    private String phoneNumber;
    //date'ler için LocalDate gibi özel veri tipleri işimizi kolaylaştırabilir
    //dateOfBirth
    //dateOfStart
    private String email;
   
    public Employee(int employeeId, String username, String password, String role,
                    String name, String surname, String phoneNumber, String email){
       
       this.employeeId = employeeId;
       this.username = username;
       this.password = password;
       this.role = role;
       this.name = name;
       this.surname = surname;
       this.phoneNumber = phoneNumber;
       this.email = email;

   }

   //       !!!NOT!!!  setter ve getter dalgasını update metodlarınaa göre çöz

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }



    public void updateEmail(String updatedEmail){

        this.email = updatedEmail;
    }

    public void updatePassword(String updatedPassword){

        this.password = updatedPassword;
    }

    public void updatePhoneNumber(String updatedPhoneNumber){

        this.phoneNumber = updatedPhoneNumber;
    }

    public void displayProfile() {
        System.out.println("Password: " + password);
        System.out.println("Phone No: " + phoneNumber);
        System.out.println("Email: " + email);
    }
   
    public void displayNonProfile() {
        System.out.println("Name: " + name + " " + surname);
        System.out.println("Username: " + username);
        System.out.println("Role: " + role);
        //System.out.println("Date of Birth: " + dateOfBirth);
        //System.out.println("Date of Start: " + dateOfStart);
    }


   public static void main(String[] args) {
       
       Employee employee1 = new Employee(123456, "sezowastaken", "951753",
       "Technician", "Sezai", "Araplarlı",
       "+90 533 791 83 37", "sezowastaken@hotmail.com");

       employee1.displayProfile();
       System.out.println("------------------------------------");
       employee1.updateEmail("sezowastaken@stu.khas.edu.tr");
       employee1.displayProfile();
   }
   

}