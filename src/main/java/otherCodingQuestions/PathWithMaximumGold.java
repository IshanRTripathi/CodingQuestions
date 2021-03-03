package main.java.otherCodingQuestions;//Problem Question Link - https://leetcode.com/problems/path-with-maximum-gold/

import java.io.*;
import java.util.*;

public class PathWithMaximumGold {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m= sc.nextInt();
        int n= sc.nextInt();
        int[][] grid= new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
                grid[i][j]= sc.nextInt();
        }
        System.out.println(getMaximumGold(grid));
    }
    private static int getMaximumGold(int[][] grid) {
        int res=0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                res= Math.max(res, dfs(Arrays.copyOf(grid, grid.length), i, j));
            }
        }
        return res;
    }

    private static int dfs(int[][] grid, int i, int j)
    {
        if(!inBounds(grid, i, j))
            return 0;
        int origin=grid[i][j];
        grid[i][j]=0;
        int amt=0;
        amt=Math.max(amt, dfs(grid, i+1, j));
        amt=Math.max(amt, dfs(grid, i, j+1));
        amt=Math.max(amt, dfs(grid, i-1, j));
        amt=Math.max(amt, dfs(grid, i, j-1));
        grid[i][j]=origin;
        return amt+origin;
    }
    private static boolean inBounds(int[][] grid, int i, int j)
    {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] != 0;
    }
}