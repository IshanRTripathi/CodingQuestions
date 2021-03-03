package main.java.otherCodingQuestions;/*
Question Link - https://leetcode.com/problems/rotate-image/
*/

import java.io.*;
import java.util.*;

public class RotateImage {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix= new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]= sc.nextInt();
            }
        }
        rotate(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        int size= matrix.length;
        if(matrix.length==0 || matrix[0].length==0 || matrix==null)
            return;
        for(int i=0; i<size/2; i++)
        {
            for(int j=i; j<size-i-1; j++)
            {
                int temp= matrix[i][j];
                matrix[i][j]=matrix[size-1-j][i];//matrix[j][size-1-i];
                matrix[size-1-j][i]=matrix[size-1-i][size-1-j];
                matrix[size-1-i][size-1-j]=matrix[j][size-1-i];
                matrix[j][size-1-i]=temp;
                // matrix[j][size-1-i]=matrix[size-1-i][size-1-j];
                // matrix[size-1-i][size-1-j]=matrix[size-1-j][i];
                // matrix[size-1-j][i]=temp;
            }
        }
    }
}