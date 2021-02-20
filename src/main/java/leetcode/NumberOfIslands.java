package main.java.leetcode;

import java.util.Scanner;

/*
https://leetcode.com/problems/number-of-islands
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'
*/
public class NumberOfIslands {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m= sc.nextInt();
        int n= sc.nextInt();
        sc.nextLine();
        char[][] grid= new char[m][n];
        for(int i=0; i<m; i++){
            String input= sc.nextLine();
            for(int j=0; j<n; j++){
                grid[i][j]= input.charAt(j);
            }
        }
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int res=0;
        if(grid==null ||grid.length==0 || grid[0].length==0)
            return 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    void dfs(char[][] grid, int i, int j){
        if(i<0 ||i>grid.length-1 || j<0 || j>grid[i].length-1 || grid[i][j]=='0')
            return;
        grid[i][j]='0';

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
