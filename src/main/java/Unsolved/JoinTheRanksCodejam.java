package Unsolved;/*
Question Link - 
*/

import java.io.*;
import java.util.*;

public class JoinTheRanksCodejam {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int r= sc.nextInt();
            int s= sc.nextInt();
            int i=1, j=1;
            List<String> a= new ArrayList<>();

            for (int q = 0; q < r*s; q++) {
                if(i>=r && q%r==0)
                    i=1;
                if(q>0 && q%r==0)
                    j++;
                String e= i+""+j;
                i++;
                a.add(e);
            }

            System.out.println("Original : "+a);
            while(!sorted(a))
            {
                a= process(a, r, s);
                Thread.sleep(2000);
            }
            
        }
    }

    private static List<String> process(List<String> a, int r, int s) {
        int i=r*s-1;

        while(i>0 && a.get(i).charAt(0)>a.get(i-1).charAt(0))
                i--;
        System.out.print("B starting from "+(i-1));
        int b2=--i;
        while(i>0 && a.get(i).charAt(0)>a.get(i-1).charAt(0))
            i--;
        System.out.println(" to "+i);
        int b1=i;
        int a2=b1-1;
        int a1=0;
        System.out.println("A starting from "+a1+" to "+a2);
        for(int itr=b2; itr>=b1; itr--)
        {
            String temp= a.remove(itr);
            a.add(0, temp);
        }
        System.out.print((a2-a1+1)+" : "+(b2-b1+1));
        System.out.println(" : "+a);
        System.out.println("-----------------------\n");
        return  a;
    }

    private static boolean sorted(List<String> a) {
        for(int i=0; i<a.size(); i++)
            if(Integer.parseInt(a.get(i).charAt(0)+"")>Integer.parseInt(a.get((i+1)%a.size()).charAt(0)+""))
                return false;
        return true;
    }
}