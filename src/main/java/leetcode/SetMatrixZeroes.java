package main.java.leetcode;
/*
* Link - https://leetcode.com/problems/set-matrix-zeroes/

Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?


Example 1:

Input: matrix =
3 3
1 1 1
1 0 1
1 1 1

Output:
1 0 1
0 0 0
1 0 1

* Example 2:

Input:
3 4
0 1 2 0
3 4 5 2
1 3 1 5

Output:
 0 0 0 0
 0 4 5 0
 0 3 1 0


Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
2^-31 <= matrix[i][j] <= 2^31 - 1
* */

import main.java.customClass.Pair;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int row= sc.nextInt(),
                col= sc.nextInt();

        int[][] matrix= new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                matrix[i][j]= sc.nextInt();
            }
        }
        setZeroes(matrix);
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return;
        Set<Pair> set= new HashSet<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]==0)
                    set.add(new Pair(i,j));
            }
        }
        for(Pair p: set){
            int x= p.getX(), y=p.getY();
            for(int i=0; i<matrix.length; i++){
                matrix[i][y]=0;
            }
            for(int i=0; i<matrix[0].length; i++){
                matrix[x][i]=0;
            }
        }
    }
}