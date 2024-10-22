# oop1
OOP Project 1
Brief of Project and Important Dates 
 In the First Project of the CMPE343 course, you will develop a console application with 
Java (only one class with many methods) and generate documentation with JavaDoc tool. 
Your application must perform all the operations detailed under the Scenario-Objectives 
header. Each student will upload the Deliverables via learn.khas.edu.tr and join the 
presentations. Scenario-Objectives, Deliverables, Grading Formula, and Presentation details 
are in the following headers. Important dates for the First Project are: 
 15.October.2024 15:00-16:00 Kick-Off of project @ B-522. 
 1.November.2024 20:00 Due date for upload of deliverables. 
 4, 5, 11, 12 November 2024 Live Demo & QA @ B-311 & B-522. 
Project Scenario-Objectives
 When the user initiates the application through the command prompt, the program will 
display a welcome message using ASCII Art (https://en.wikipedia.org/wiki/ASCII_art), which 
includes the names of the team members. The user will then be prompted to select an 
operation from a menu. The menu will present the following options: 
 [A] Statistical Information about an array, 
 [B] Matrix Operations, 
 [C] Text Encryption/Decryption, 
 [D] Tic-tac-toe HotSeat, 
 [E] Terminate. 
The application should continue running unless the user chooses to terminate it. If an invalid 
option is selected, the user will be notified, and the menu will be re-displayed. 
 When the user selects option A, the console will be cleared, and the program will 
display the name of the operation. The user will then be prompted to input the size of the array, 
followed by the elements (as double values). The program will compute and display statistical 
information such as the median, arithmetic mean, geometric mean, and harmonic mean of the 
array. Once completed, the user will be prompted to return to the main menu. If an invalid data 
type is entered, the program will alert the user to correct it, but it will not terminate. The 
harmonic mean must be calculated using a recursive method. You should prefer an approach 
to find the median in even-sized vectors. 
 When the user selects option B, the screen will be cleared, and a submenu will appear, 
offering operations such as Transpose, Inverse, Matrix Multiplication, Element-wise 
Multiplication, and Return to the Main Menu. The user will first enter the dimensions of the 
matrix or matrices and then input the values for each matrix element. The program will compute 
and display the results of the chosen operation in a formatted output. After completing the 
2 
operation, the user will be prompted to return to the submenu. If an invalid data type is entered, 
the program will prompt the user to correct the input without terminating. It is important to note 
that not all matrices are non-singular square matrices, and this should be handled accordingly.
You are not allowed to use predefined methods for matrix operations instead you will code 
your own methods. 
 When the user selects option C, the screen will be cleared, and a submenu will be 
displayed, listing operations such as Encryption, Decryption, and Return to the Main Menu. If 
the user selects Encryption or Decryption, they will be asked to provide an integer shift value 
within the range [-26, 26] and input the text to encrypt or decrypt. The program will use the 
Caesar cipher encryption technique (https://en.wikipedia.org/wiki/Caesar_cipher) to process 
the text. A shift value of zero indicates no encryption. Positive shift values will shift characters 
to the right during encryption and to the left during decryption. Negative shift values will shift 
characters to the left during encryption and to the right during decryption. If the shift value is 
outside the valid range, the program will display an error message and return to the submenu. 
Non-alphabetic characters (such as digits and spaces) should remain unchanged. 
You should study java.lang.Character: 
(https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Character.html) 
Example 
key: 5 
message: This is nice! 
encrypted message: Ymnx nx snhj! 
key: 5 
message: Ymnx nx snhj! 
decrypted message: This is nice! 
 When the user selects option D, the screen will be cleared, and the board will be 
initialized to an empty state. The Tic-Tac-Toe game (https://en.wikipedia.org/wiki/Tic-tac-toe) 
will proceed in turns, with player X going first, followed by player O. The game will continue 
until a player wins or the board is full, resulting in a tie. After each move, the program will check 
for a winner. The program should restrict the players to valid moves (i.e., the cell must be 
unoccupied, and the input must be valid). If an invalid move is attempted, the player will be 
prompted to try again. At the end of the game, the program will display the final result (X wins, 
O wins, or a tie) along with the total number of turns. 
 Starting with this project, you are required to use Javadoc style comments. This allows 
for the automatic generation of HTML documentation for your code and is the standard for 
Java developers (https://docs.oracle.com/en/java/javase/23/javadoc/javadoc-tool.html). You 
should document your classes and methods with as many relevant tags as possible. 
 Your project should consist of a single source file (.java) that contains the main method 
and several public methods reflecting the various operations. Ensure that your code runs 
without errors before submission. The team will collaborate on the code using GitHub, and 
you will share your source code with the assigned assistant. You must present your application 
to the assistant to receive approval for participation in the live demo. 
Deliverables
 Each student will upload two files to the learn.khas.edu.tr via assignments tab: 
 java source code of the project (GroupXX.java) 
 zip file containing Javadoc documents related to your code (GroupXX.zip) 
 Note that .java and .zip files within the group must be the same! 


Tasks:
A and B - Dilvin and Zülal
C - Tuna
D - Emir
E - Sezai
