package main.java.leetcode;

import main.java.customClass.Pair;

import java.util.*;
/*
Link - https://leetcode.com/problems/shortest-path-in-binary-matrix/

In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k
such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.
If such a path does not exist, return -1.
*/
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter row and column values");
        System.out.println("Then enter the matrix values");
        int row= sc.nextInt();
        int col= sc.nextInt();

        int[][] grid= new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                grid[i][j]= sc.nextInt();
            }
        }
        System.out.println("Shortest path in the given matrix is of length "+ shortestPathBinaryMatrix(grid));
    }
    static int shortestPathBinaryMatrix(int[][] grid){
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1)
            return -1;
        Set<Pair> visited= new HashSet<>();
        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair(0,0));
        queue.add(null);

        int res=0;
        while(!queue.isEmpty()){
            Pair temp =queue.remove();

            if(temp==null){
                if(queue.peek()==null)
                    return -1;
                res++;
                queue.add(null);
                continue;
            }

            if(!(checkUnderConstraints(temp, grid)))
                continue;
            if(visited.contains(temp)){
                continue;
            }

            visited.add(temp);
            System.out.println("Visited co-ordinate : "+temp);

            if(temp.getX()==grid.length-1 && temp.getY()==grid[0].length-1)
                return res+1;

            queue.add(new Pair(temp.getX()+1, temp.getY()));
            queue.add(new Pair(temp.getX()-1, temp.getY()));
            queue.add(new Pair(temp.getX()+1, temp.getY()+1));
            queue.add(new Pair(temp.getX()-1, temp.getY()+1));
            queue.add(new Pair(temp.getX()+1, temp.getY()-1));
            queue.add(new Pair(temp.getX()-1, temp.getY()-1));
            queue.add(new Pair(temp.getX(), temp.getY()+1));
            queue.add(new Pair(temp.getX(), temp.getY()-1));
        }
        return -1;
    }

    private static boolean checkUnderConstraints(Pair temp, int[][] grid) {
        return temp.getX()>=0 && temp.getY()<grid[0].length && temp.getX()<grid.length && temp.getY()>=0 && grid[temp.getX()][temp.getY()]==0;
    }

}

