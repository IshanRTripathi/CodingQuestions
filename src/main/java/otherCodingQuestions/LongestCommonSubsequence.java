package main.java.otherCodingQuestions;/*
Question Link - https://leetcode.com/problems/longest-common-subsequence/
*/

import java.io.*;
import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string : ");
        String text1= sc.nextLine();
        System.out.println("Enter second string : ");
        String text2= sc.nextLine();

        System.out.println("Length of Longest Common Subsequence : \n" + longestCommonSubsequence(text1, text2));
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        char[] t1= text1.toCharArray();
        char[] t2= text2.toCharArray();

        int[][] dp= new int[t1.length+1][t2.length+1];

        for(int i=1; i<=t1.length; i++)
        {
            for(int j=1; j<=t2.length; j++)
            {
                if(t1[i-1]==t2[j-1])
                    dp[i][j]= dp[i-1][j-1]+1;
                else
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        printDPMatrix(dp);  // Prints the DP Matrix
        return dp[t1.length][t2.length];
    }

    private static void printDPMatrix(int[][] dp) {
        for (int[] row: dp) {
            for (int x:row) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}