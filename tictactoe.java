import java.util.Scanner;

public class tictactoe {

    private static char[][] board=new char[3][3]; // 3x3 game board
    
    public static void main(String[] args){ // main 
        
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

            }
            else if(totMoves==8){
                printBoard();
                System.out.println("There is no winner. Tie situation!");
            }
            currentPlayer=(currentPlayer=='X')?'O':'X';
            totMoves++;

        }
        
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
    
    private static void playerTurn(char player){ // player turn
        Scanner scanner = new Scanner(System.in);
        int row, col;
        boolean isValid=false;
        while (!isValid){
            System.out.println("Player " + player + ", please choose row and column number (0, 1 or 2): ");
            row=scanner.nextInt();
            col=scanner.nextInt();
            
            // avaliable move or not
            if(row>=0 && row<3 && col>=0 && col<3 && board[row][col]=='-'){
                board[row][col]=player; // we can see move in the table
                isValid=true;
            }
            else{
                System.out.println("Unavaliable move, try again");
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



}
//eeş
