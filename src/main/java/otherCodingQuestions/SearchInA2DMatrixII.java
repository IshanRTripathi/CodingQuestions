package main.java.otherCodingQuestions;/*
Question Link - https://leetcode.com/problems/search-a-2d-matrix-ii/
*/

import java.io.*;
import java.util.*;

public class SearchInA2DMatrixII {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int m= sc.nextInt();
        sc.nextLine();
        int[][] matrix= new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j]= sc.nextInt();
            }
        }
        int target= sc.nextInt();
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;

        int r=0, c=matrix[0].length-1;
        while(r<matrix.length && c>=0)
        {
            if(matrix[r][c]==target)
                return true;
            else if(matrix[r][c]>target)
                c--;
            else if(target> matrix[r][c])
                r++;
        }
        return false;
    }
}