import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    final private static String inputMatrixRow = "Enter the number of rows of the matrix. ";
    final private static String inputMatrixColumn = "Enter the number of column of the matrix. ";
    final private static String matrixMatchError ="Matrix dimensions do not match, operation cannot be performed. ";
    final private static String overflowError ="Matrices must be between 2 and 5. ";
    final private static String inputMatrix ="Enter matrix elements. ";
    final private static String squareError ="Matrix must be Square. ";
    final private static String inputScalar ="Enter the scalar value. ";

    /**
     * ASCII art to welcome the user
     * Main menu to decide on operations
     * Using if - else structure to call and combine the necessary methods and perform the selected operation
     * @param args Command line arguments
     * @author Sezai Araplarlı
     */
    public static void main(String[] args) {



    	String asciiArt0 =
                        " __      _____________.____   _________  ________      _____  ___________ \n"+
    		            "/  \\    /  \\_   _____/|    |  \\_   ___ \\ \\_____  \\    /     \\ \\_   _____/ \n"+
    		            "\\   \\/\\/   /|    __)_ |    |  /    \\  \\/  /   |   \\  /  \\ /  \\ |    __)_  \n"+
    		            " \\        / |        \\|    |__\\     \\____/    |    \\/    Y    \\|        \\ \n"+
    		            "  \\__/\\  / /_______  /|_______ \\______  /\\_______  /\\____|__  /_______  / \n"+
                        "       \\/          \\/         \\/      \\/         \\/         \\/        \\/  ";

    	
    	System.out.println(asciiArt0);

        String asciiArt00 =
                        "\t __      _____________      _____ _____________________\n"+
    		            "\t/  \\    /  \\_   _____/     /  _  \\\\______   \\_   _____/\n"+
    		            "\t\\   \\/\\/   /|    __)_     /  /_\\  \\|       _/|    __)_ \n"+
    		            "\t \\        / |        \\   /    |    \\    |   \\|        \\\n"+
    		            "\t  \\__/\\  / /_______  /   \\____|__  /____|_  /_______  /\n"+
                        "\t       \\/          \\/            \\/       \\/        \\/ ";
    			        
    	
    	System.out.println(asciiArt00);
    	
    	String asciiArt1 =
    			        "________  .__.__                           _____            .___.__        \n"+
    		            "\\______ \\ |__|  |___  _______    ____     /  _  \\ ___.__. __| _/|__| ____  \n"+
    		            " |    |  \\|  |  |\\  \\/ /\\__  \\  /    \\   /  /_\\  <   |  |/ __ | |  |/    \\ \n"+
    		            " |    `   \\  |  |_\\   /  / __ \\|   |  \\ /    |    \\___  / /_/ | |  |   |  \\\n"+
    		            "/_______  /__|____/\\_/  (____  /___|  / \\____|__  / ____\\____ | |__|___|  /\n"+
                        "        \\/                   \\/     \\/          \\/\\/         \\/         \\/ ";
    	
    	System.out.println(asciiArt1);
    	
    
    	
    	String asciiArt2 =
    			        "__________     .__         .__      _________                                    \n"+
    		            "\\____    /__ __|  | _____  |  |    /   _____/ ____   ____   _____   ____ ________\n"+
    		            "  /     /|  |  \\  | \\__  \\ |  |    \\_____  \\ /  _ \\ /    \\ /     \\_/ __ \\\\___   /\n"+
    		            " /     /_|  |  /  |__/ __ \\|  |__  /        (  <_> )   |  \\  Y Y  \\  ___/ /    / \n"+
    		            "/_______ \\____/|____(____  /____/ /_______  /\\____/|___|  /__|_|  /\\___  >_____ \\\n"+
                        "        \\/               \\/               \\/            \\/      \\/     \\/      \\/";
    	
    	System.out.println(asciiArt2);
        
        String asciiArt3 =
    			        "  _________                     .__     _____                      .__               .__  .__ \n"+
    		            " /   _____/ ____ _____________  |__|   /  _  \\____________  ______ |  | _____ _______|  | |__|\n"+
    		            " \\_____  \\_/ __ \\\\___   /\\__  \\ |  |  /  /_\\  \\_  __ \\__  \\ \\____ \\|  | \\__  \\\\_  __ \\  | |  |\n"+
    		            " /        \\  ___/ /    /  / __ \\|  | /    |    \\  | \\// __ \\|  |_> >  |__/ __ \\|  | \\/  |_|  |\n"+
    		            "/_______  /\\___  >_____ \\(____  /__| \\____|__  /__|  (____  /   __/|____(____  /__|  |____/__|\n"+
                        "        \\/     \\/      \\/     \\/             \\/           \\/|__|             \\/               ";
    	
    	System.out.println(asciiArt3);

        String asciiArt4 =
    			        "___________                  .__                    ___________                   \n"+
    		            "\\__    ___/_ __  ____ _____  |  |__ _____    ____   \\__    ___/_ __________ ____  \n"+
    		            "  |    | |  |  \\/    \\\\__  \\ |  |  \\\\__  \\  /    \\    |    | |  |  \\___   // __ \\ \n"+
    		            "  |    | |  |  /   |  \\/ __ \\|   Y  \\/ __ \\|   |  \\   |    | |  |  //    /\\  ___/ \n"+
    		            "  |____| |____/|___|  (____  /___|  (____  /___|  /   |____| |____//_____ \\\\___  >\n"+
                        "                    \\/     \\/     \\/     \\/     \\/                       \\/    \\/ ";
    	
    	System.out.println(asciiArt4);

        String asciiArt5 =
    			        "___________       .__         ___________                   .___   _________      .__    .__        \n"+
    		            "\\_   _____/ _____ |__|______  \\_   _____/ ___________     __| _/  /   _____/____  |  |__ |__| ____  \n"+
    		            " |    __)_ /     \\|  \\_  __ \\  |    __)_ /  ___/\\__  \\   / __ |   \\_____  \\\\__  \\ |  |  \\|  |/    \\ \n"+
    		            " |        \\  Y Y  \\  ||  | \\/  |        \\\\___ \\  / __ \\_/ /_/ |   /        \\/ __ \\|   Y  \\  |   |  \\\n"+
    		            "/_______  /__|_|  /__||__|    /_______  /____  >(____  /\\____ |  /_______  (____  /___|  /__|___|  /\n"+
                        "        \\/      \\/                    \\/     \\/      \\/      \\/          \\/     \\/     \\/    \n\n";
    	
    	System.out.println(asciiArt5);
        

        int operation;
        String menuBorder = "+---------------------------------------+";

        while (true){
            System.out.println(menuBorder);
            System.out.println("1 - Statistical Information about an array\n"
                             + "2 - Matrix Operations\n"
                             + "3 - Text Encryption/Decryption\n" 
                             + "4 - Tic Tac Toe Game\n"
                             + "5 - Terminate");
            System.out.println(menuBorder);
            System.out.print("Welcome user, please select an operation above :");
            operation = scanner.nextInt();
    
            if (operation == 1){
                
                clearTerminal();
                boolean continueProgram = true; 
    
                while (continueProgram) {
                    
                    System.out.print("Please enter the array size (Enter 0 to exit):");
                    int size = scanner.nextInt();
        
                    if (size == 0) {
                        continueProgram = false;
                        break;
                    }
        
                    int[] array = new int[size];
        
                    
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < size; i++) {
                        System.out.print((i + 1) + ". Enter element : ");
                        array[i] = scanner.nextInt();
                    }
        
                    
                    boolean continueQuery = true;
                    while (continueQuery) {
                        
                        System.out.println("Which statistical information would you like to see?");
                        System.out.println("1. Sum");
                        System.out.println("2. Mean");
                        System.out.println("3. Median");
                        System.out.println("4. Mode");
                        System.out.println("5. Standart Deviation");
                        System.out.print("Make your choice (1-5): ");
                        int choice = scanner.nextInt();
        
                      
                        switch (choice) {
                            case 1:
                                System.out.println("Sum: " + calculateSum(array));
                                break;
                            case 2:
                                System.out.println("Mean: " + calculateMean(array));
                                break;
                            case 3:
                                System.out.println("Median: " + calculateMedian(array));
                                break;
                            case 4:
                                System.out.println("Mode: " + calculateMode(array));
                                break;
                            case 5:
                                System.out.println("Standard Deviation: " + calculateStandardDeviation(array));
                                break;
                            default:
                                System.out.println("Invalid chioce!");
                                continue; 
                        }
        
                        
                        System.out.print("\"Would you like to see another statistical information? (Please Enter 1 for Yes, 0 for No): ");
                        int continueChoice = scanner.nextInt();
                        continueQuery = (continueChoice == 1);
                    }
                }
        
                System.out.println("Program terminated.");
                clearTerminal();
                 
                
            }
    
            else if (operation == 2){

                clearTerminal();
                List<String> menuList = new ArrayList<>(List.of(
                    "| 1. Matrix Addition                   |",
                    "| 2. Matrix Subtraction                |",
                    "| 3. Matrix Multiplication             |",
                    "| 4. Scalar Division                   |",
                    "| 5. Scalar Multiplication             |",
                    "| 6. Transpose                         |",
                    "| 7. Inverse                           |",
                    "| 8. Trace                             |",
                    "| 9. Adjoint                           |",
                    "| 10. Check Orthogonality              |",
                    "| 11. Terminate                        |"
            ));
    
                while (true) {
                    System.out.println(menuBorder);
                    System.out.println("|        Matrix Calculator Menu        |");
    
                    for (int i = 0; i < menuList.stream().count(); i++) {
                        System.out.println(menuList.get(i));
                    }
    
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
    
                    if (choice == 11) {
                        System.out.println("Exiting the program.");
                        break;
                    }
                    switch (choice) {
                        case 1:
                            System.out.println("Matrix Addition");
                            ArrayList values = getValuesByUser();
                            if (values == null) {
                                break;
                            } else {
                                matrixAddition((Integer) values.get(0),
                                        (Integer) values.get(1),
                                        (Integer) values.get(2),
                                        (Integer) values.get(3),
                                        (double[][]) values.get(4),
                                        (double[][]) values.get(5));
                                break;
                            }
    
                        case 2:
                            System.out.println("Matrix Subtraction");
                            ArrayList valuesList = getValuesByUser();
                            if (valuesList == null) {
                                break;
                            } else {
                                matrixSubstraction((Integer) valuesList.get(0),
                                        (Integer) valuesList.get(1),
                                        (Integer) valuesList.get(2),
                                        (Integer) valuesList.get(3),
                                        (double[][]) valuesList.get(4),
                                        (double[][]) valuesList.get(5));
                                break;
                            }
    
                        case 3:
                            System.out.println("Matrix Multiplication");
                            ArrayList multiplicationValues = getValuesByUser();
                            if (multiplicationValues == null) {
                                break;
                            } else {
                                matrixMultiplication((Integer) multiplicationValues.get(0),
                                        (Integer) multiplicationValues.get(1),
                                        (Integer) multiplicationValues.get(2), (Integer) multiplicationValues.get(3),
                                        (double[][]) multiplicationValues.get(4),
                                        (double[][]) multiplicationValues.get(5));
                                break;
                            }
    
    
                        case 4:
                            System.out.println("Scalar Division");
                            ArrayList divisionInputs = getScalarAndMatrixValuesByUser();
                            if (divisionInputs == null) {
                                break;
                            } else {
                                scalarDivisionMatrix((Integer) divisionInputs.get(0),
                                        (Integer) divisionInputs.get(1),
                                        (double[][]) divisionInputs.get(2),
                                        (double) divisionInputs.get(3));
                                break;
                            }
    
                        case 5:
                            System.out.println("Scalar Multiplication");
                            ArrayList scalarmultpInputs = getScalarAndMatrixValuesByUser();
                            if (scalarmultpInputs == null) {
                                break;
                            } else {
                                scalarMultiplicationMatrix((Integer) scalarmultpInputs.get(0),
                                        (Integer) scalarmultpInputs.get(1),
                                        (double[][]) scalarmultpInputs.get(2),
                                        (double) scalarmultpInputs.get(3)
                                );
                                break;
                            }
    
                        case 6:
                            System.out.println("Transpose");
                            ArrayList transposeInputs = getOnlyMatrixValuesByUser(choice);
                            if (transposeInputs == null) {
                                break;
                            } else {
                                matrixTranspose((Integer) transposeInputs.get(0),
                                        (Integer) transposeInputs.get(1),
                                        (double[][]) transposeInputs.get(2)
                                );
                                break;
                            }
                        case 7:
                            System.out.println("Inverse");
                            ArrayList inverseMatrixInput = getOnlyMatrixValuesByUser(choice);
                            if (inverseMatrixInput == null) {
                                break;
                            } else {
                                inverse((Integer) inverseMatrixInput.get(0),
                                        (Integer) inverseMatrixInput.get(1),
                                        (double[][]) inverseMatrixInput.get(2)
                                );
                                break;
                            }
                        case 8:
                            System.out.println("Trace");
                            ArrayList traceOfMatrixInputs = getOnlyMatrixValuesByUser(choice);
                            if (traceOfMatrixInputs == null) {
                                break;
                            } else {
                                traceOfMatrix((Integer) traceOfMatrixInputs.get(0),
                                        (Integer) traceOfMatrixInputs.get(1),
                                        (double[][]) traceOfMatrixInputs.get(2)
                                );
                                break;
                            }
    
                        case 9:
                            System.out.println("Adjoint");
                            ArrayList addJointMatrixInputs = getOnlyMatrixValuesByUser(choice);
                            if (addJointMatrixInputs == null) {
                                break;
                            } else {
                                adjointMatrix((double[][]) addJointMatrixInputs.get(2));
                                break;
                            }
    
    
                        case 10:
                            System.out.println("Check Orthogonality ");
                            ArrayList checkOrthInputs = getValuesByUser();
                            if (checkOrthInputs == null) {
                                break;
                            } else {
                                checkOrthogonality((Integer) checkOrthInputs.get(0),
                                        (Integer) checkOrthInputs.get(1),
                                        (Integer) checkOrthInputs.get(2),
                                        (Integer) checkOrthInputs.get(3),
                                        (double[][]) checkOrthInputs.get(4),
                                        (double[][]) checkOrthInputs.get(5));
                                break;
                            }
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
    
            }
    
            else if (operation == 3){
                String message;
                int number;
                clearTerminal();
                boolean over = true;
                while(over){
                    System.out.println("Plase select one of them");
                    System.out.println("[+] = Message encryption");
                    System.out.println("[-] = Message decoding");
                    System.out.println("[*] = Back to menu");
                    
                    char selection = scanner.next().charAt(0);
                    scanner.nextLine();
    
                    //(selection.charAt(0) != '+' && selection.charAt(0) != '-' && selection.charAt(0) != '*')
                    
                    if(selection != '+' && selection != '-' && selection != '*'){
                        System.out.println("You have entered an incorrect entry and are being redirected back to the main menu.");
                    }
                    else{
                        boolean cond = true;
                        while(cond){
                            
                            if(selection == '*'){
                                cond=false;
                                over = false;
                                clearTerminal();
                            }
                            else if(selection == '+'){
                                message = getMessage(); // Mesajı al
                                number = enc_number();  // Şifreleme numarasını al
                                String enc_message_out = text_to_enc(message, number); // Şifreleme işlemi
                                print_enc_message(number,"Encrypted Message: " + enc_message_out); // Şifrelenmiş mesajı yazdır
                                cond=false;
                            }
                            else if(selection == '-'){
                                message=get_en_Message();
                                number = enc_number();
                                String enc_message_out =text_to_dec(message, number);
                                print_enc_message(number, "Decrypted message: "+ enc_message_out);
                                cond=false;
                            }
                        }
            
            
                    }
                }
                	
            }
    
            else if (operation == 4){
                clearTerminal();
                startBoard();
                char currentPlayer = 'X';
                boolean winSituation=false;
                int totMoves=0;
                while(!winSituation && totMoves<9){
                    printBoard();
                    playerTurn(currentPlayer);
                    winSituation= whoWins(currentPlayer);
                    if(winSituation){
                        printBoard();
                        System.out.println("Player " + currentPlayer + " won!");
                        System.out.println("Total number of moves : " + totMoves);
                        
        
                    }
                    else if(totMoves==8){
                        printBoard();
                        System.out.println("There is no winner. Tie situation!");
                    }
                    currentPlayer=(currentPlayer=='X')?'O':'X';
                    totMoves++;
        
                }
    
            }

            else if (operation == 5){
                System.out.println("Have a nice day");
                break;
            }
            
            else{
                System.out.println("You have entered invalid operation. Please enter a valid number.");
    
            }

        }
        
        



        scanner.close();
    }

    
    // METHODS OF STATISTICS OF AN ARRAY PART

    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    public static double calculateMean(int[] array) {
        return (double) calculateSum(array) / array.length;
    }

    public static double calculateMedian(int[] array) {
        Arrays.sort(array);
        int middle = array.length / 2;
        if (array.length % 2 == 0) {
            return (array[middle - 1] + array[middle]) / 2.0;
        } else {
            return array[middle];
        }
    }

    public static int calculateMode(int[] array) {
        int maxValue = 0, maxCount = 0;
        for (int i = 0; i < array.length; ++i) {
            int count = 0;
            for (int j = 0; j < array.length; ++j) {
                if (array[j] == array[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static double calculateStandardDeviation(int[] array) {
        double mean = calculateMean(array);
        double sum = 0;
        for (int num : array) {
            sum += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sum / array.length);
    }
    

    // METHODS OF MATRIX OPERATIONS 

    private static ArrayList getValuesByUser() {
        System.out.print("First " + inputMatrixRow);
        int matrix1Rows = scanner.nextInt();
        System.out.print("First " + inputMatrixColumn);
        int matrix1Columns = scanner.nextInt();


        System.out.print("Second " + inputMatrixRow);
        int matrix2Rows = scanner.nextInt();
        System.out.print("Second " + inputMatrixColumn);
        int matrix2Columns = scanner.nextInt();


        if (matrix1Columns != matrix2Rows) {
            System.out.println(matrixMatchError);
            return null;
        } else if ((matrix1Rows > 5 || matrix1Rows < 2) && (matrix1Columns > 5 || matrix1Columns < 2)) {
            System.out.println(overflowError);
            return null;
        } else {
            double[][] matrix1 = new double[matrix1Rows][matrix1Columns];
            System.out.println("First "+inputMatrix);
            for (int i = 0; i < matrix1Rows; i++) {
                for (int j = 0; j < matrix1Columns; j++) {
                    matrix1[i][j] = scanner.nextInt();
                }
            }


            double[][] matrix2 = new double[matrix2Rows][matrix2Columns];
            System.out.println("Second "+inputMatrix);
            for (int i = 0; i < matrix2Rows; i++) {
                for (int j = 0; j < matrix2Columns; j++) {
                    matrix2[i][j] = scanner.nextInt();
                }
            }

            List values = new ArrayList() {
                {
                    add(matrix1Rows);
                    add(matrix1Columns);
                    add(matrix2Rows);
                    add(matrix2Columns);
                    add(matrix1);
                    add(matrix2);
                }
            };
            return (ArrayList) values;
        }
    }

    private static ArrayList getScalarAndMatrixValuesByUser() {
        System.out.print(inputScalar);
        double scalar = scanner.nextDouble();

        System.out.print(inputMatrixRow);
        int matrix1Rows = scanner.nextInt();
        System.out.print(inputMatrixColumn);
        int matrix1Columns = scanner.nextInt();



        if ((matrix1Rows > 5 || matrix1Rows < 2) || (matrix1Columns > 5 || matrix1Columns < 2)) {
            System.out.println(overflowError);
            return null;
        } else {
            double[][] matrix1 = new double[matrix1Rows][matrix1Columns];
            System.out.println(inputMatrix);
            for (int i = 0; i < matrix1Rows; i++) {
                for (int j = 0; j < matrix1Columns; j++) {
                    matrix1[i][j] = scanner.nextInt();
                }
            }

            List<Integer> values = new ArrayList() {
                {
                    add(matrix1Rows);
                    add(matrix1Columns);
                    add(matrix1);
                    add(scalar);
                }
            };
            return (ArrayList) values;
        }
    }

    private static ArrayList getOnlyMatrixValuesByUser(int caseValue) {

        System.out.print(inputMatrixRow);
        int matrix1Rows = scanner.nextInt();
        System.out.print(inputMatrixColumn);
        int matrix1Columns = scanner.nextInt();



        if ((matrix1Rows > 5 || matrix1Rows < 2) || (matrix1Columns > 5 || matrix1Columns < 2)) {
            System.out.println(overflowError);
            return null;
        } else if (matrix1Rows != matrix1Columns && (caseValue == 8 || caseValue == 9 || caseValue == 7)) {
            System.out.println(squareError);
            return null;


        } else {
            double[][] matrix1 = new double[matrix1Rows][matrix1Columns];
            System.out.println(inputMatrixRow);
            for (int i = 0; i < matrix1Rows; i++) {
                for (int j = 0; j < matrix1Columns; j++) {
                    matrix1[i][j] = scanner.nextInt();
                }
            }

            List<Integer> values = new ArrayList() {
                {
                    add(matrix1Rows);
                    add(matrix1Columns);
                    add(matrix1);

                }
            };
            return (ArrayList) values;
        }
    }

    private static void matrixAddition(int matrix1Rows, int matrix1Columns, int matrix2Rows, int matrix2Columns, double[][] matrix1, double[][] matrix2) {



        double[][] result = new double[matrix1Rows][matrix1Columns];
        for (int i = 0; i < matrix1Rows; i++) {
            for (int j = 0; j < matrix1Columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }


        System.out.println("Matrix addition result: ");
        for (int i = 0; i < matrix1Rows; i++) {
            for (int j = 0; j < matrix1Columns; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void matrixSubstraction(int matrix1Rows, int matrix1Columns, int matrix2Rows, int matrix2Columns, double[][] matrix1, double[][] matrix2) {

        double[][] matrixResult = new double[matrix1Rows][matrix1Columns];

        for (int i = 0; i < matrix1Rows; i++) {
            for (int j = 0; j < matrix1Columns; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        if (matrixResult != null) {
            System.out.println("Result of matrix substraction is:");
            for (int i = 0; i < matrixResult.length; i++) {
                for (int j = 0; j < matrixResult[i].length; j++) {
                    System.out.print(matrixResult[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void matrixMultiplication(int matrix1Rows, int matrix1Columns, int matrix2Rows, int matrix2Columns, double[][] matrix1, double[][] matrix2) {

        double[][] matrixResult = new double[matrix1Rows][matrix2Columns];

        for (int i = 0; i < matrix1Rows; i++) {
            for (int j = 0; j < matrix2Columns; j++) {
                for (int k = 0; k < matrix1Columns; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        if (matrixResult != null) {
            System.out.println("Matrix multiplication result: ");
            for (int i = 0; i < matrixResult.length; i++) {
                for (int j = 0; j < matrixResult[i].length; j++) {
                    System.out.print(matrixResult[i][j] + " ");
                }
            }

            System.out.println();
        }
    }


    private static void scalarMultiplicationMatrix(int matrixRows, int matrixColumns, double[][] matrix, double scalar) {

        double[][] resultMatrix = new double[matrixRows][matrixColumns];

        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                resultMatrix[i][j] = matrix[i][j] * scalar;
            }
        }

        System.out.println("Scalar Multiplication of Matrix:");
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void scalarDivisionMatrix(int matrixRows, int matrixColumns, double[][] matrix, double scalar) {

        double[][] resultMatrix = new double[matrixRows][matrixColumns];

        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                resultMatrix[i][j] = matrix[i][j] / scalar;
            }
        }

        System.out.println("Scalar Division of Matrix:");
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void traceOfMatrix(int matrixRows, int matrixColumns, double[][] matrix) {
        if (matrixRows != matrixColumns) {
            System.out.println("Error: The trace is only defined for a square matrix.");

        } else {
            double trace = 0.0;

            for (int i = 0; i < matrixRows; i++) {
                trace += matrix[i][i];
            }

            System.out.println("Trace of the matrix is: " + trace);
        }
    }

    private static void inverse(int matrixRows, int matrixColumns, double[][] matrix) {
        int n = matrix.length;

        if (n != matrix[0].length) {
            System.out.println(squareError);

        }

        double[][] augmentedMatrix = new double[n][2 * n];

        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
                augmentedMatrix[i][j + n] = (i == j) ? 1.0 : 0.0;
            }
        }

        for (int i = 0; i < n; i++) {
            double pivot = augmentedMatrix[i][i];

            if (pivot == 0.0) {
                System.out.println("The matrix is singular (its determinant is zero), its inverse calculation cannot be performed.");

            }

            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= pivot;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = augmentedMatrix[i][j + n];
            }
        }

        System.out.println("Inverse of the Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    private static void checkOrthogonality(int matrix1Rows, int matrix1Columns, int matrix2Rows, int matrix2Columns, double[][] matrix1, double[][] matrix2) {


        double[][] transposeMatrix1 = matrixTranspose(matrix1Rows, matrix1Columns, matrix1);

        double[][] resultMatrix = new double[matrix1Rows][matrix2Rows];
        for (int i = 0; i < matrix1Rows; i++) {
            for (int j = 0; j < matrix2Rows; j++) {
                resultMatrix[i][j] = 0;
                for (int k = 0; k < matrix1Columns; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * transposeMatrix1[j][k];
                }
            }
        }


        boolean isOrthogonal = true;
        for (int i = 0; i < matrix1Rows; i++) {
            for (int j = 0; j < matrix2Rows; j++) {
                if (i == j) {
                    if (Math.abs(resultMatrix[i][j] - 1.0) > 1e-10) {
                        isOrthogonal = false;
                        break;
                    }
                } else {
                    if (Math.abs(resultMatrix[i][j]) > 1e-10) {
                        isOrthogonal = false;
                        break;
                    }
                }
            }
            if (!isOrthogonal) {
                break;
            }
        }

        if (isOrthogonal) {
            System.out.println("The matrices are orthogonal.");
        } else {
            System.out.println("The matrices are not orthogonal.");
        }


    }


    private static double[][] matrixTranspose(int matrixRows, int matrixColumns, double[][] matrix) {


        double[][] transpose = new double[matrixColumns][matrixRows];

        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }


        System.out.println("Transpose of Matrix:");
        for (int i = 0; i < matrixColumns; i++) {
            for (int j = 0; j < matrixRows; j++) {
                System.out.print(transpose[i][j] + " ");

            }
            System.out.println();

        }
        return transpose;
    }


    private static void adjointMatrix(double[][] matrix) {
        int n = matrix.length;
        double[][] adjoint = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double[][] minor = getMinor(matrix, i, j);
                double cofactor = Math.pow(-1, i + j) * determinant(minor);
                adjoint[j][i] = cofactor;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjoint[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static double determinant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int j = 0; j < n; j++) {
            double[][] minor = getMinor(matrix, 0, j);
            det += matrix[0][j] * Math.pow(-1, j) * determinant(minor);
        }

        return det;
    }

    private static double[][] getMinor(double[][] matrix, int row, int col) {
        int n = matrix.length;
        double[][] minor = new double[n - 1][n - 1];
        int newRow = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) {
                continue;
            }
            int newCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) {
                    continue;
                }
                minor[newRow][newCol] = matrix[i][j];
                newCol++;
            }
            newRow++;
        }
        return minor;
    }


    // METHODS OF TEXT ENCRYPTION - DECRYPTION

    public static String getMessage(){

		System.out.print("Please, enter your message to be encrypted: ");
		String message = scanner.nextLine();
		System.out.println("Your message before encrypted: " +message);
		return message;
	}

	public static String get_en_Message(){
		
		System.out.print("Please, enter your encryted message to be decryption: ");
		String message = scanner.nextLine();
		System.out.println("Your message before decrytion: " +message);
		return message;
	}

    /**
     * 
     * @return
     * @author Tunahan Tuze
     * @author Sezai Araplarlı
     */
	public static int enc_number(){
        
        int number;
        System.out.println("Please, enter a number for encryption.");
        System.out.println("It should be between [-26, 26].");

        while (true) {
            number = scanner.nextInt();
            if (number > 26 || number < -26) {
                System.out.println("You entered the wrong range and you are returned to the main menu.");
                return 0; 
            } else {
                break; 
            }
        }
        return number; 
	}

	public static String text_to_enc(String message,int number)
	{
		String enc_message="";

		for(int i =0; i<message.length(); i++){
			char ch = message.charAt(i);
			if((message.charAt(i)>=65) && (message.charAt(i)<=90)){
				ch = (char) (((ch - 65 + number) % 26 + 26) % 26 + 65);
			}
			else if((message.charAt(i)>=97) && (message.charAt(i)<=122)){
				ch = (char) (((ch - 97 + number) % 26 + 26) % 26 + 97);
            	}
				enc_message+=ch;
			}
			return enc_message;
	}

	public static String text_to_dec(String message, int number) {
		return text_to_enc(message, -number); 
	}

	public static void print_enc_message(int number,String enc_message_out){
		if (number > 26 || number < -26){
		}
		else{
			System.out.println("Encrypted Message: " + enc_message_out);
		}
	}

    // METHODS OF TIC TAC TOE GAME

    private static char[][] board=new char[3][3]; // 3x3 game board

    private static void startBoard(){ //creating game board
        for (int i=0;i<3;i++){ //rows
            for (int j=0;j<3;j++){ // cols
                board[i][j]='-';
            }
        }
    }

    private static void printBoard(){ // prints the board
        System.out.println("Board: "); // adds next line after the print operation
        for(int i=0;i<3;i++){ // basic array print operation
            for(int k=0;k<3;k++){
                System.out.print(board[i][k] + "");  
            }
            System.out.println();
        }
    }
    
    /**
     * 
     * @param player
     * @author Emir Esad Şahin
     * @author Sezai Araplarlı
     */
    private static void playerTurn(char player){ // player turn
        int row, col;
        boolean isValid=false;
        while (!isValid){
            System.out.println("Player " + player + ", please choose row and column number (0, 1 or 2): ");
            System.out.print("Row : ");
            row=scanner.nextInt();
            System.out.print("Column : ");
            col=scanner.nextInt();
            
            // avaliable move or not
            if(row>=0 && row<3 && col>=0 && col<3 && board[row][col]=='-'){
                board[row][col]=player; // we can see move in the table
                isValid=true;
            }
            else{
                System.out.println("Unavaliable move, try again");
                printBoard();
            }
        }
    
    }

    private static boolean whoWins(char player) {
        // check rows of board
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
                
            }
        }

        // check columns of board
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        // check crosses of board
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;  // If there is no win situation, it returns false
        
    }

    // TERMINAL CLEANER METHOD

    /**
     * clears terminal (may not work on some IDE's)
     * @author Sezai Araplarlı
     */
    public static void clearTerminal() {
        String operating_system = System.getProperty("os.name").toLowerCase();

        if (operating_system.contains("win")) {
            runCommand("cmd /c cls"); // for Windows 
        } else {
            runCommand("clear");      // for MacOS or Linux 
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * runs command on windows/mac/linux terminals
     * @param command terminal command to run
     * @author Sezai Araplarlı
     */
    private static void runCommand(String command) {
        try {
            new ProcessBuilder(command.split(" ")).inheritIO().start().waitFor();
        } catch (Exception ignored) {

        }
    }
}
