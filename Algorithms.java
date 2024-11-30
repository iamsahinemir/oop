import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
            } else {
                System.out.println(blue+ "Invalid input!!! "+ yellow + "Please enter a valid number: "+ reset);
                input.next();
            }
            input.close();
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
    
    public static void radixSort(int[] array) {
    // Radix sort algoritması buraya yazılır
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
    
    
    
    public static void heapSort(int[] heaparray) {
        int n = heaparray.length;  
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






    public static void main(String[] args) {
        String reset = "\033[0m";
        String blue = "\033[34m";
        String yellow = "\033[33m";
        // Menü gösterimi
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
                // Kullanıcıdan giriş al ve sıralama işlemlerini çalıştır

                int userInput = User_input();
                int[] randomArray = generate_Random_Array(userInput);
                int[] radix_Array = generate_radix_Array(randomArray,userInput);
                int[] shell_Array = generate_shell_Array(randomArray,userInput);
                int[] heap_Array = generate_heap_Array(randomArray,userInput);
                int[] insertion_Array = generate_insertion_Array(randomArray,userInput);
                int[] shell_Sort = shellSort(shell_Array);
                //int[] heap_Sort = heapSort(heap_Array);
                int[] insertion_Sort = insertionSort(insertion_Array);
                
                System.out.println();
            
                // for (int number: shell_Sort) {
                    
                //     System.out.println(number + " ");
                // }
                for(int number: insertion_Sort){

                    System.out.println(number + " ");
                }
                //test için array yazdırma
                // System.out.println(blue + "Generated Random Array:" + reset);
                // for (int number : randomArray) {
                //     System.out.print(number + " ");
                // }
                // System.out.println(); 
                // for (int number : radix_Array) {
                //     System.out.print(number + " ");
                // }
                // System.out.println(); 
                // for (int number : shell_Array) {
                //     System.out.print(number + " ");
                // }
                // System.out.println(); 
                // for (int number : heap_Arrayy) {
                //     System.out.print(number + " ");
                // }
                // System.out.println(); 
                // for (int number : insertion_Array) {
                //     System.out.print(number + " ");
                // }
                // System.out.println(); 
                break;
            }
            input.close();
        }

    }
}
