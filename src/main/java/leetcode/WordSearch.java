package main.java.leetcode;
/*
{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}
"ABCESEEEFS"
*/
public class WordSearch {
    public static void main(String[] args) {
        char[][] board= new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word= "AAB";
        char[][] board1= new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};

        String word1= "ABCESEEEFS";
        System.out.println(new WordSearch().exist(board1, word1));
    }

    public boolean exist(char[][] board, String word) {
        boolean result= false;
        int pi=-1, pj=-1;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(word.charAt(0)== board[i][j]){
                    System.out.println("Checking for : "+i+", "+j);
                    result= backtrack(getNewBoard(board), i, j, word, pi, pj);
                    if(result)
                        return true;
                }
            }
        }
        return false;
    }

    private char[][] getNewBoard(char[][] board) {
        char[][] copy= new char[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                copy[i][j]= board[i][j];
            }
        }
        new WordSearch().printBoard(copy);
        return copy;
    }

    boolean backtrack(char[][] board, int i, int j, String word, int pi, int pj) {
        if(i==pi && j==pj)
            return true;

        if(word== null || word.length()==0)
            return true;

        if(i<0 || i>= board.length || j<0 || j>= board[i].length || word.charAt(0)!= board[i][j]) {
            System.out.println("Terminating for "+i+", "+j);
            return false;
        }
        System.out.println("Choosing "+i+", "+j);
        board[i][j]= '1';
        pi= i;
        pj= j;

        printBoard(board);

        String newWord= word.substring(1, word.length());
        System.out.println("\t\t\t"+i+", "+j+" Remaining : "+newWord);
        return backtrack(board, i+1, j, newWord, pi, pj) ||
                backtrack(board, i-1, j, newWord, pi, pj) ||
                backtrack(board, i, j+1, newWord, pi, pj) ||
                backtrack(board, i, j-1, newWord, pi, pj);
    }

    private void printBoard(char[][] board) {
        for(char[] line: board){
            for(char c: line){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}
