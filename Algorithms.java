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
        }
    }
    //alınan inputtan random array üretme
    public static int[] generateRandomArray(int size_of_array) { 
        Random random = new Random();
        int[] randomArray = new int[size_of_array];

        for (int i = 0; i < size_of_array; i++) {
            randomArray[i] = random.nextInt(20001) - 10000; // -10,000 ile 10,000 arasında
        }

        return randomArray;
    }






    public static void main(String[] args) {
        String reset = "\033[0m";
        String blue = "\033[34m";
        String yellow = "\033[33m";

        // Menü gösterimi
        System.out.println(yellow + "====== MANAGER MENU ======" + reset);
        System.out.println(blue + "1. Run " + yellow + "Sorting " + blue + "Algorithms" + reset);
        System.out.println(yellow + "2. Exit...." + reset);
        int userInput = User_input();
        int[] randomArray = generateRandomArray(userInput);

        //test için array yazdırma
        System.out.println(blue + "Generated Random Array:" + reset);
        for (int number : randomArray) {
            System.out.print(number + " ");
        }
        System.out.println(); 
    }
}

