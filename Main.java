package pro2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    public static void main(String[] args) {

    	
    	
    	String asciiArt1 =
    			        " ,------.  ,--.,--.,--.   ,--.,--.,--.  ,--.   ,---.,--.   ,--.,------.  ,--.,--.  ,--.\n"+
    		            " |  .-.  \\ |  ||  | \\  `.'  / |  ||  ,'.|  |  /  O  \\|  `.'  / |  .-.  \\ |  ||  ,'.|  |\n"+
    		            " |  |  \\  :|  ||  |  \\     /  |  ||  |' '  | |  .-.  |'.    /  |  |  \\  :|  ||  |' '  |\n"+
    		            " |  '--'  /|  ||  '--.\\   /   |  ||  | `   | |  | |  |  |  |   |  '--'  /|  ||  | `   |\n"+
    		            " `-------' `--'`-----' `-'    `--'`--'  `--' `--' `--'  `--'   `-------' `--'`--'  `--'";
    	
    	System.out.println(asciiArt1);
    	
    
    	
    	String asciiArt2 =
    			        ",-------.,--. ,--.,--.     ,---.  ,--.     ,---.   ,-----. ,--.  ,--.,--.   ,--.,------.,-------.\n"+
    				    "`--.   / |  | |  ||  |    /  O  \\ |  |    '   .-' '  .-.  '|  ,'.|  ||   `.'   ||  .---'`--.   /\n"+
    				    "  /   /  |  | |  ||  |   |  .-.  ||  |    `.  `-. |  | |  ||  |' '  ||  |'.'|  ||  `--,   /   /\n"+
    				    " /   `--.'  '-'  '|  '--.|  | |  ||  '--. .-'    |'  '-'  '|  | `   ||  |   |  ||  `---. /   `--.\n"+
    				    "`-------' `-----' `-----'`--' `--'`-----' `-----'  `-----' `--'  `--'`--'   `--'`------'`-------'";
    	
    	System.out.println(asciiArt2);	
    			
    	
        String menuBorder = "+---------------------------------------+";

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

        scanner.close();
    }

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
}