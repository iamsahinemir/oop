public abstract class Employee {
    protected int e_id;
    protected String username;
    protected String password;
    protected String role;
    protected String name;
    protected String surname;
    protected String phoneNumber;
    protected String dateOfBirth;
    protected String dateOfStart;
    protected String email;

    public Employee(int e_id, String username, String password, String role, String name,
                    String surname, String phoneNumber, String dateOfBirth, String dateOfStart, String email) {
        this.e_id = e_id;
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

    public abstract void displayProfile();

    public void updateProfile(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        System.out.println("Profile updated successfully.");
    }

    // Getters and Setters
    public int getE_id() { 
        return e_id; 
    }
    public String getUsername() { 
        return username; 
    }
    public String getPassword() { 
        return password; 
    }
    public String getRole() { 
        return role; 
    }
    public String getName() { 
        return name; 
    }
    public String getSurname() { 
        return surname; 
    }
    public String getPhoneNumber() { 
        return phoneNumber; 
    }
    public String getDateOfBirth() { 
        return dateOfBirth; 
    }
    public String getDateOfStart() { 
        return dateOfStart; 
    }
    public String getEmail() { 
        return email; 
    }


    public void setE_id(int e_id) { this.e_id = e_id; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setDateOfStart(String dateOfStart) { this.dateOfStart = dateOfStart; }
    public void setEmail(String email) { this.email = email; }
}
