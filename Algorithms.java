import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Algorithms class provides implementations of various sorting algorithms
 * Radix Sort, Heap Sort, Shell Sort, Insertion Sort, and utility methods.
 * 
 * @author Zulal Sonmez
 * @author Dilvin Aydin
 * @author Tunahan Tuze
 */
public class Algorithms {
     /**
     * This takes user input for the size of the array to generate.
     *
     * @return the valid input number between 1,000 and 10,000
     * @author Tunahan Tuze
     */
    
    public static int User_input() {
        String reset = "\033[0m";
        String blue = "\033[34m";
        String yellow = "\033[33m";
        Scanner input = new Scanner(System.in);
        int number;

        System.out.println(blue + "Please, enter a number"+ yellow + " between 1,000 and 10,000:"+reset);

        while (true) {
            if (input.hasNextInt()) { 
                number = input.nextInt();
                if (number >= 1000 && number <= 10000) {
                    return number; 
                } else {
                    System.out.println(yellow+ "The number is not in range!"+blue +" Please enter a number in range:"+reset);
                }
            }
            else  {
                System.out.println(blue+ "Invalid input!!! "+ yellow + "Please enter a valid number: "+ reset);
                input.next();
            }
            
        }
    }
    /**
     * It generates a random array based on the user input
     *
     * @param size_of_array the size of the array to generate
     * @return  generated random array
     * @author Tunahan Tuze
     */
    public static int[] generate_Random_Array(int size_of_array) { 
        Random random = new Random();
        int[] randomArray = new int[size_of_array];

        for (int i = 0; i < size_of_array; i++) {
            randomArray[i] = -10000 + random.nextInt(20001); // -10,000 ile 10,000 arasında
        }

        return randomArray;
        
    }
     /**
     * It generates a copy of the given array for Radix Sort.
     * 
     * @param randomArray the array to copy
     * @param size_of_array the size of the array
     * @return  copied array
     * @author Tunahan Tuze
     */
    public static int[] generate_radix_Array(int[] randomArray, int size_of_array){

        int[] radix_Array = new int [size_of_array];
        for(int i = 0; i<size_of_array;i++){
            radix_Array[i] = randomArray[i];

        }
        return radix_Array;
    }

     /**
     * Generates a copy of the given array for Shell Sort.
     * 
     * @param randomArray the array to copy
     * @param size_of_array the size of the array
     * @return copied array
     * @author Tunahan Tuze 
     */

    public static int[] generate_shell_Array(int[] randomArray, int size_of_array){

        int[] shell_Array = new int [size_of_array];
        for(int i = 0; i<size_of_array; i++){
            shell_Array[i] = randomArray[i];
        }
        return shell_Array;
    }   
    
     /**
     * It generates a copy of the given array for Heap Sort.
     * 
     * @param randomArray the array to copy
     * @param size_of_array the size of the array
     * @return copied array
     * @author Tunahan Tuze 
     */

    public static int[] generate_heap_Array(int []randomArray, int size_of_array){

        int[] heap_Array = new int [size_of_array];
        for(int i = 0; i<size_of_array; i++){
            heap_Array[i] = randomArray[i];
            
        }
        return heap_Array;
    }
     /**
     * It generates a copy of the given array for insertion dort.
     * 
     * @param randomArray the array to copy
     * @param size_of_array the size of the array
     * @return copied array
     * @author Tunahan Tuze 
     */
    public static int[] generate_insertion_Array(int[] randomArray, int size_of_array){

        int[] insertion_Array = new int [size_of_array];
        for(int i = 0 ; i<size_of_array; i++){
            insertion_Array[i] = randomArray[i];
        }
        
        return insertion_Array;
    }

    /**
     * This performs radix sort on the input array.
     * 
     * @param array the array to be sorted
     * @return the sorted array
     * @author Zulal Sonmez
     * @author Dilvin Aydin
     */
    

    public static int[] radixSort(int[] array) {
        // Negatif ve pozitif sayıları ayır
        int[] negatives = Arrays.stream(array).filter(n -> n < 0).map(n -> -n).toArray(); // Negatifleri pozitif yap
        int[] positives = Arrays.stream(array).filter(n -> n >= 0).toArray();
        
        
        if (positives.length > 0) {
            radixSortPositive(positives);
        }

        
        if (negatives.length > 0) {
            radixSortPositive(negatives);
            for (int i = 0; i < negatives.length; i++) {
                negatives[i] = -negatives[i]; 
            }
            reverseArray(negatives); 
        }

       
        int[] fullArray = new int[array.length];
        System.arraycopy(negatives, 0, fullArray, 0, negatives.length); 
        System.arraycopy(positives, 0, fullArray, negatives.length, positives.length); 

        return fullArray; 
    }

    /**
     * It is a helper method in radix sort to sort the  positive part of the array.
     * @param array the array to sort
     */
    private static void radixSortPositive(int[] array) {
        int max = Arrays.stream(array).max().orElse(0); 
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp); 
        }
    }
    
     /**
     * It is a helper method to perform counting sort based on the current digit.
     * 
     * @param array the array to sort
     * @param exp the current digit place value
     */
    
    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

       
        System.arraycopy(output, 0, array, 0, n);
    }
    /**
     * This reverses the order of elements in the array.
     * @param array the array to reverse
     */
    private static void reverseArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }
    } 
    /**
     * This performs shell sort on the input array.
     * 
     * @param shellarray the array to be sorted
     * @return the sorted array
     * @author Tunahan Tuze
     */

    public static int[] shellSort(int[] shellarray) {
        int n = shellarray.length;

    
        for (int gap = n / 2; gap > 0; gap /= 2) { 
            for (int i = gap; i < n; i++) { 
                int temp = shellarray[i];
                int j = i;
    
                
                while (j >= gap && shellarray[j - gap] > temp) {
                    shellarray[j] = shellarray[j - gap];
                    j -= gap;
                }
    
                
                shellarray[j] = temp;
            }
        }
    
        return shellarray; 
    }
        /**
     * This performs heap sort on the input array.
     * 
     * @param heaparray the array to be sorted
     * @return the sorted array
     * @author Dilvin Aydin
     * @author Zülal Sönmez
     */
    public static int[] heapSort(int[] heaparray) {
        int n = heaparray.length;
    
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(heaparray, n, i);
        }
    
        for (int i = n - 1; i > 0; i--) {
            int temp = heaparray[0];
            heaparray[0] = heaparray[i];
            heaparray[i] = temp;
    
            heapify(heaparray, i, 0);
        }
        return heaparray;
    }
      /**
     * ıt is a helper method to maintain the heap property.
     * 
     * @param heaparray the array representing the heap
     * @param n the size of the heap
     * @param i the index of the element to heapify
     */
    private static void heapify(int[] heaparray, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2;
    
        if (left < n && heaparray[left] > heaparray[largest]) {
            largest = left;
        }
    
        if (right < n && heaparray[right] > heaparray[largest]) {
            largest = right;
        }
    
        if (largest != i) {
            int temp = heaparray[i];
            heaparray[i] = heaparray[largest];
            heaparray[largest] = temp;
    
            heapify(heaparray, n, largest);
        }
    }
   /**
     * This performs insertion sort on the input array.
     * 
     * @param insertionarray the array to be sorted
     * @return the sorted array
     * @author Tunahan Tuze
     */
    public static int[] insertionSort(int[] insertionArray) {
        int n = insertionArray.length;

        for (int i = 1; i < n; ++i) {
            int key = insertionArray[i];
            int j = i - 1;

            
            while (j >= 0 && insertionArray[j] > key) {
                insertionArray[j + 1] = insertionArray[j];
                j = j - 1;
            }
            insertionArray[j + 1] = key;
        }
        return insertionArray;
    }
       /**
     * This sorts the input list using the built-in Collections.sort method.
     * 
     * @param array the list of integers to be sorted
     * @return the sorted list
     * @author Tunahan Tuze
     */
    public static List<Integer> collenction_Sort(List<Integer> array){
        Collections.sort(array); 
        return array;
    }
    /**
     * This compares two arrays and it checks if they are equal
     * 
     * @param shell_Arrayy the array to compare
     * @param connection_Array the list to compare against
     * @return true if the arrays are equal,  otherwise false
     * @author Tunahan Tuze 
     */
    public static boolean isEqual(int[] shell_Arrayy, List<Integer> connection_Array) {
        if (shell_Arrayy.length != connection_Array.size()) {
            return false;
        }
        for (int i = 0; i < shell_Arrayy.length; i++) {
            if (shell_Arrayy[i] != connection_Array.get(i)) {
                return false;
            }
        }
        return true;
    }
     
    /**
     * This compares an insertion sorted array and a list to check for equality.
     * 
     * @param instertion_Arrayy the insertion sorted array
     * @param connection_Array the list to compare against
     * @return true if the array and list are equal, otherwise false
     * @author Tunahan Tuze 
     */
    public static boolean isEqualInsertionforinsertion(int[] instertion_Arrayy, List<Integer> connection_Array) {
        if (instertion_Arrayy.length != connection_Array.size()) {
            return false;
        }
        for (int i = 0; i < instertion_Arrayy.length; i++) {
            if (instertion_Arrayy[i] != connection_Array.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqualRadix(int[] Radix_Arrayy, List<Integer> connection_Array) {
        if (Radix_Arrayy.length != connection_Array.size()) {
            return false;
        }
        for (int i = 0; i < Radix_Arrayy.length; i++) {
            if (Radix_Arrayy[i] != connection_Array.get(i)) {
                return false;
            }
        }
        return true;
    }
     /**
     * This compares a radix sorted array and a list to check for equality.
     * 
     * @param Radix_Arrayy the radix sorted array
     * @param connection_Array the list to compare against
     * @return true if the array and list are equal, otherwise otherwise
     * @author Tunahan Tuze 
     */

    public static boolean isEqualHeap(int[] Heap_Arrayy, List<Integer> connection_Array) {
        if (Heap_Arrayy.length != connection_Array.size()) {
            return false;
        }
        for (int i = 0; i < Heap_Arrayy.length; i++) {
            if (Heap_Arrayy[i] != connection_Array.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This send to this in database .
     * 
     * @param size return de size of main array 
     * @return dataset for value 
     * @author Emir Esad Şahin
     */
    public static int[] generateDataset(int size) {
        int[] dataset = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
        dataset[i] = random.nextInt(100000); // Random values between 0 and 99999
        }
        return dataset;
    }

}