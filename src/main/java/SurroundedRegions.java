/*
Question Link - https://leetcode.com/problems/surrounded-regions/
*/

import java.io.*;
import java.util.*;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0)
            return;
        boolean mark=true;
        for(int i=0; i<board.length; i++)
        {
            if(board[i][0]=='O')
                dfs(board, i, 0, mark);
            if(board[i][board[i].length-1]=='O')
                dfs(board, i, board[i].length-1, mark);
        }
        for(int j=0; j<board[0].length; j++)
        {
            if(board[0][j]=='O')
                dfs(board, 0, j, mark);
            if(board[board.length-1][j]=='O')
                dfs(board, board.length-1, j, mark);
        }
        mark= false;

        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
            {
                if(board[i][j]=='O')
                    dfs(board, i, j, mark);
            }
        }

        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
            {
                if(board[i][j]=='L')
                    board[i][j]='O';
            }
        }
    }

    void dfs(char[][]board, int i, int j, boolean mark)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]=='X' || board[i][j]=='L')
            return;
        if(mark==true)
            board[i][j]='L';
        else
            board[i][j]='X';
        dfs(board, i+1, j, mark);
        dfs(board, i, j+1, mark);
        dfs(board, i-1, j, mark);
        dfs(board, i, j-1, mark);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n,m;
            n= sc.nextInt();
            m=sc.nextInt();

            System.out.println("Enter values alphabets 'O' OR 'X' ");

            char[][] board= new char[n][m];

            for(int i=0; i<n; i++)
            {
                String row= sc.nextLine();
                for(int j=0; j<m; j++)
                {
                    board[i][j]= row.charAt(j);
                }
            }

            for(char[] row: board)
            {
                for(char c: row)
                    System.out.print(c+" ");
                System.out.println();
            }
        }
    }
}