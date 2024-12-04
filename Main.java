/**
 * Main class provides access AsciiArt and Login classes.
 * Main class of the program
 * 
 * @author Emir Esad Sahin
 */
public class Main {
    public static void main(String[] args) {
        AsciiArt.displayArt(); 
        Login login = new Login();
        login.start();   
    }
}
