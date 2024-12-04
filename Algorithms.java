import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithms {
  
    // kullanıcdan input alma
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
    //alınan inputtan random array üretme
    public static int[] generate_Random_Array(int size_of_array) { 
        Random random = new Random();
        int[] randomArray = new int[size_of_array];

        for (int i = 0; i < size_of_array; i++) {
            randomArray[i] = -10000 + random.nextInt(20001); // -10,000 ile 10,000 arasında
        }

        return randomArray;
        
    }

    public static int[] generate_radix_Array(int[] randomArray, int size_of_array){

        int[] radix_Array = new int [size_of_array];
        for(int i = 0; i<size_of_array;i++){
            radix_Array[i] = randomArray[i];

        }
        return radix_Array;
    }

    public static int[] generate_shell_Array(int[] randomArray, int size_of_array){

        int[] shell_Array = new int [size_of_array];
        for(int i = 0; i<size_of_array; i++){
            shell_Array[i] = randomArray[i];
        }
        return shell_Array;
    }   
        
    public static int[] generate_heap_Array(int []randomArray, int size_of_array){

        int[] heap_Array = new int [size_of_array];
        for(int i = 0; i<size_of_array; i++){
            heap_Array[i] = randomArray[i];
            
        }
        return heap_Array;
    }
    
    public static int[] generate_insertion_Array(int[] randomArray, int size_of_array){

        int[] insertion_Array = new int [size_of_array];
        for(int i = 0 ; i<size_of_array; i++){
            insertion_Array[i] = randomArray[i];
        }
        
        return insertion_Array;
    }
    
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

    
    private static void radixSortPositive(int[] array) {
        int max = Arrays.stream(array).max().orElse(0); 
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp); 
        }
    }

    
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

    
    private static void reverseArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }
    } 

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

    public static List<Integer> collenction_Sort(List<Integer> array){
        Collections.sort(array); 
        return array;
    }

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






    /*public static void main(String[] args) {
        String reset = "\033[0m";
        String blue = "\033[34m";
        String yellow = "\033[33m";
        String greenBold = "\033[1;32m";
        String red = "\033[0;31m";
        while (true) {
            System.out.println(yellow + "====== MANAGER MENU ======" + reset);
            System.out.println(blue + "1. Run " + yellow + "Sorting " + blue + "Algorithms" + reset);
            System.out.println(yellow + "2. Exit...." + reset); 
            Scanner input = new Scanner(System.in);
            String selection = input.nextLine(); 
            if (selection.charAt(0) != '1' && selection.charAt(0) != '2') {
                System.out.println(blue + "You have entered an invalid number" + reset);
            } else if (selection.charAt(0) == '2') {
                // Çıkış
                System.out.println(yellow + "Exiting program. Goodbye!" + reset);
                break;
            } else if (selection.charAt(0) == '1') {
                //int[]arraytest={120,240,32,46,5,6,7,8,9,10,1111};
                int userInput = User_input();
                int[] randomArray = generate_Random_Array(userInput);
                int[] radix_Array = generate_radix_Array(randomArray,userInput);
                int[] shell_Array = generate_shell_Array(randomArray,userInput);
                int[] heap_Array = generate_heap_Array(randomArray,userInput);
                int[] insertion_Array = generate_insertion_Array(randomArray,userInput);
                int[] shell_Sort = shellSort(shell_Array);
                int[] insertion_Sort = insertionSort(insertion_Array);
                int[] heap_Sort = heapSort(heap_Array);
                int[] radix_Sort = radixSort(radix_Array);
                List<Integer> numbers = new ArrayList<Integer>();
                for (int num : randomArray) {
                    numbers.add(num); 
                }
                List<Integer> collection_sort = collenction_Sort(numbers); 
                boolean isEqualShell = isEqual(shell_Sort, collection_sort);
                boolean isEqualInsertionforinsertion = isEqual(insertion_Sort, collection_sort);
                boolean isEqualRadix = isEqual(radix_Sort, collection_sort);
                Boolean isEqualHeap = isEqual(heap_Sort,collection_sort);
                
                long shellStartTime = System.nanoTime();
                shell_Sort = shellSort(shell_Array);
                long shellEndTime = System.nanoTime();
                long shellExecutionTime = shellEndTime - shellStartTime;
                
                
                long insertionStartTime = System.nanoTime();
                insertion_Sort = insertionSort(insertion_Array);
                long insertionEndTime = System.nanoTime();
                long insertionExecutionTime = insertionEndTime - insertionStartTime;
                
                long RadixStartTime = System.nanoTime();
                insertion_Sort = insertionSort(radix_Array);
                long RadixEndTime = System.nanoTime();
                long RadixExecutionTime = RadixEndTime - RadixStartTime;
                
                long HeapStartTime = System.nanoTime();
                insertion_Sort = insertionSort(radix_Array);
                long HeapEndTime = System.nanoTime();
                long HeapExecutionTime = HeapEndTime - HeapStartTime;
                
                
                
                
                
                System.out.println(red+"-     Algorthms Name   ---      Duration(Ns)      -"+reset);
                System.out.println(greenBold+"|-----------------------|-------------------------|"+reset);
                System.out.println(greenBold + "|" +blue +"    Shell Sort         "+ greenBold+ "|        " + yellow +       shellExecutionTime + " ns" + reset);
                System.out.println(greenBold+"|-----------------------|-------------------------|"+reset);
                System.out.println(greenBold + "|" +blue + "    Insertion Sort     "+ greenBold+ "|         " + yellow +    insertionExecutionTime + " ns" + reset );
                System.out.println(greenBold + "|-----------------------|-------------------------|"+reset);
                System.out.println(greenBold + "|" +blue +"    Radix Sort         "+ greenBold+ "|        " + yellow +      RadixExecutionTime + " ns"  +reset);
                System.out.println(greenBold+"|-----------------------|-------------------------|"+reset);
                System.out.println(greenBold + "|" +blue +"    Heap Sort          " + greenBold+ "|         "+ yellow +      HeapExecutionTime + " ns" + reset );
                System.out.println(greenBold+"|-----------------------|-------------------------|"+reset);
                

                System.out.println();
                System.out.println(blue+"Shell Sort is equals Collection Sort: " +yellow+ isEqualShell+reset);
                System.out.println(yellow+"Insertion Sort is equals Collection Sort: " + blue + isEqualInsertionforinsertion+reset);
                System.out.println(blue+"Radix Sort is equals Collection Sort: " +yellow+ isEqualRadix+reset);
                System.out.println(yellow+"Heap Sort is equals Collection Sort: " + blue + isEqualHeap+reset);
                System.out.println();
                System.out.println();
                
                break;
            }
        }
        
        

    }*/


public static int[] generateDataset(int size) {
    int[] dataset = new int[size];
    Random random = new Random();
    for (int i = 0; i < size; i++) {
        dataset[i] = random.nextInt(100000); // Random values between 0 and 99999
    }
    return dataset;
}

}