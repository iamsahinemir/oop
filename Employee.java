
public class Employee {

    protected int employeeId;      //şimdilik kullanılmıyor
    protected String username;
    protected String password;
    protected String role;           //role için sadece 4 rolden biri olabilecek şekilde bir ayarlama çözmemiz lazım
    protected String name;
    protected String surname;
    protected String phoneNumber;
    //date'ler için LocalDate gibi özel veri tipleri işimizi kolaylaştırabilir
    //dateOfBirth
    //dateOfStart
    protected String email;
   
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
    

        //EMAIL GETTER AND SETTER
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


        //PASSWORD GETTER AND SETTER
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


        //PHONE NUMBER GETTER AND SETTER
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


        //EMPLOYEE NAME GETTER AND SETTER
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }


        //EMPLOYEE SURNAME GETTER AND SETTER
    public String getSurname(){
        return surname;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }


        //EMPLOYEE USERNAME GETTER AND SETTER
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }


        //EMPLOYEEID GETTER AND SETTER
    public int getEmployeeId(){
        return employeeId;
    }
    
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }


        //EMPLOYEE ROLE GETTER AND SETTER
    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
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
        System.out.println("employee1 password --> " + employee1.getRole());
        employee1.setEmployeeId(313131);
        System.out.println("employee1 password after change --> " + employee1.getEmployeeId());
        
   }
   

}