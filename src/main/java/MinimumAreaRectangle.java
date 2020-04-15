//Problem Question Link - https://leetcode.com/problems/minimum-area-rectangle/

import java.io.*;
import java.util.*;

public class MinimumAreaRectangle {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[][] points= new int[n][2];
        for(int i=0; i<n; i++)
        {
            points[i][0]= sc.nextInt();
        }
        Set<Integer> pointSet = new HashSet<>();
        for (int[] point: points)
            pointSet.add(40001 * point[0] + point[1]);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; ++i)
            for (int j = i+1; j < points.length; ++j) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (pointSet.contains(40001 * points[i][0] + points[j][1]) &&
                            pointSet.contains(40001 * points[j][0] + points[i][1])) {
                        ans = Math.min(ans, Math.abs(points[j][0] - points[i][0]) *
                                Math.abs(points[j][1] - points[i][1]));
                    }
                }
            }

        System.out.println(ans);
    }
}