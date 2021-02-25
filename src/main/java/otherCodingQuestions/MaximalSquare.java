package main.java.otherCodingQuestions;/*
Question Link - https://leetcode.com/problems/maximal-square/
*/

import java.io.*;
import java.util.*;

public class MaximalSquare {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n= sc.nextInt();
            int m= sc.nextInt();
            sc.nextLine();
            char[][] matrix= new char[n][m];
            int i=0;
            while(n-->0) {
                String ch = sc.nextLine();
                for(int itr=0; itr<matrix.length; itr++)
                {
                    matrix[i][itr]=ch.charAt(itr);
                }
                i++;
            }
            int maxArea= maximalSquare(matrix);
            System.out.println("Maximum area of a square is : "+maxArea);
        }
    }
    public static int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        int r=matrix.length, c=matrix[0].length;

        int max=0;
        int[][]dp= new int[r+1][c+1];
        for(int i=1; i<=r; i++)
        {
            for(int j=1; j<=c; j++)
            {
                if(matrix[i-1][j-1]=='1')
                    dp[i][j]= Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                max=Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}