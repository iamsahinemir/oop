public class Utils {

    /**
     * a method that clears terminal/console
     * for better user experience
     * @author Emir Esad Sahin
     */
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ex) {
            System.out.println("Error clearing console: " + ex.getMessage());
        }
    }
}
