import java.util.Scanner;

public class tictactoe {

    private static char[][] board=new char[3][3]; // 3x3 game board
    
    public static void main(String[] args){ // main 
        
        startBoard();
        printBoard();
        char currentPlayer = 'X';
        playerTurn(currentPlayer);
        
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
    
    private static void playerTurn(char player){
        Scanner scanner=new Scanner(System.in);
        int row, col;
        boolean isValid=false;
        while (!isValid){
            System.out.println("Player " + player + ", please choose row and column number (0, 1 or 2): ");
            row=scanner.nextInt();
            col=scanner.nextInt();

            if(row>=0 && row<3 && col>=0 && col<3 && board[row][col]=='-'){
                board[row][col]=player;
                isValid=true;
            }
            else{
                System.out.println("Unavaliable move, try again");
            }
        }
    }

}
