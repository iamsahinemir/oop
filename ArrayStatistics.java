package StatisticalInformation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStatistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        scanner.close();
    }

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
}