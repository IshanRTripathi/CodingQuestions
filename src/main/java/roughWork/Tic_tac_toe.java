package main.java.roughWork;
import java.util.*;

public class Tic_tac_toe {
    static int totalComputerWins = 0;
    static int totalPlayerWins = 0;
    static int totalTies= 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of Tournaments : ");
        int totalMatches=scanner.nextInt();

        while(totalComputerWins + totalPlayerWins + totalTies < totalMatches)
        {

            char[][] board = {{' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}};

            printBoard(board);
            //int pCount=0, cCount=0;
            while (true) {

                playerTurn(board);
                if (isGameFinished(board)){
                    //pCount++;
                    break;
                }
                printBoard(board);

                computerTurn(board);
                if (isGameFinished(board)){
                    // cCount++;

                    break;
                }
                printBoard(board);

            }
            if(totalPlayerWins + totalComputerWins +totalTies == totalMatches){
                if(totalMatches%2==1 && totalComputerWins == totalPlayerWins){
                    System.out.println("Adding one more match as player and computer have equal points");
                    totalMatches++;
                }
                else {
                    System.out.println("\n\t\t\t\t\t\t\t*****************************************");
                    System.out.println("\t\t\t\t\t\t\t**              Player: " + totalPlayerWins + "              **");
                    System.out.println("\t\t\t\t\t\t\t**             Computer: " + totalComputerWins + "             **");
                    if (totalTies > 0) {
                        System.out.println("\t\t\t\t\t\t\t**               Ties: " + totalTies + "               **");
                    }
                    System.out.println("\t\t\t\t\t\t\t*****************************************");
                }
            }
        }
        scanner.close();
    }


    private static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoard(board);

            System.out.println("Player wins!");
            totalPlayerWins++;
            System.out.println("Player="+ totalPlayerWins +" "+"Computer="+ totalComputerWins);
            return true;
        }

        if (hasContestantWon(board, 'O')) {
            printBoard(board);

            System.out.println("Computer wins!");
            totalComputerWins++;
            System.out.println("Player="+ totalPlayerWins +" "+"Computer="+ totalComputerWins);
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        totalTies++;
        return true;
    }


    private static boolean hasContestantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||      //checking
                (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||      //for all
                (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||      //rows

                (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||      //checking
                (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||      //for all
                (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||      //columns

                (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||      //checking for
                (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) )       // diagonal
        {
            return true;
        }
        return false;
    }


    private static void computerTurn(char[][] board) {    //filling random moves of computer inside the board
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }


    private static boolean isValidMove (char[][] board, String position) {    // to check wheather the player's input is in empty block or not
        switch(position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    private static void playerTurn(char[][] board) {    //for talking and executing players move
        Scanner sc=new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = sc.nextLine();
            if (isValidMove(board, userInput)){
                break;
            }
            else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        placeMove(board, userInput, 'X');
    }


    private static void placeMove(char[][] board, String position, char symbol) {    // for printing the symbol x in board
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }


    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
    }

}
