import java.util.Scanner;

public class tictactoe {

    private static char[][] board=new char[3][3]; // 3x3 game board
    
    public static void main(String[] args){ // main 
        //doldurulacak
        startBoard();
        printBoard();
    }

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
    
}
