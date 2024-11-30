public abstract class Employee {

    protected int employeeId;      //şimdilik kullanılmıyor
    protected String username;
    protected String password;
    protected String role;           //role için sadece 4 rolden biri olabilecek şekilde bir ayarlama çözmemiz lazım
    protected String name;
    protected String surname;
    protected String phoneNumber;
    //date'ler için LocalDate gibi özel veri tipleri işimizi kolaylaştırabilir
    protected String dateOfBirth;
    protected String dateOfStart;
    protected String email;
   
    public Employee(int employeeId, String username, String password, String role,
                    String name, String surname, String phoneNumber, String dateOfBirth, String dateOfStart, String email){
       
       this.employeeId = employeeId;
       this.username = username;
       this.password = password;
       this.role = role;
       this.name = name;
       this.surname = surname;
       this.phoneNumber = phoneNumber;
       this.dateOfBirth = dateOfBirth;
       this.dateOfStart = dateOfStart;
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
    
        //DATE OF BIRTH GETTER AND SETTER
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }    


        //DATE OF START GETTER AND SETTER
    public String getDateOfStart(){
        return dateOfStart;
    }

    public void setDateOfStart(String dateOfStart){
        this.dateOfStart = dateOfStart;
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


    public abstract void displayProfile();
   
    public abstract void displayNonProfile();
   

}