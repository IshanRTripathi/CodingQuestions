//Problem Question Link - https://leetcode.com/problems/counting-bits/

import java.io.*;
import java.util.*;

public class CountingBits {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int prev=0;
        for(int i=1; i<=n; i++)
        {
            System.out.print(Integer.bitCount(i)+"\t");
            int curr= (int)(Math.log(i)/Math.log(2))+1;
            if(curr>prev) {
                prev=curr;
                System.out.println();
            }
        }
    }
}