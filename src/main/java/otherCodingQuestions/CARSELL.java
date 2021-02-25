package main.java.otherCodingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//https://www.codechef.com/APRIL20B/problems/CARSELL
public class CARSELL {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0)
        {
            int n= sc.nextInt();
            List<Long> list= new ArrayList<Long>();
            for(int i=0; i<n; i++)
            {
                list.add(sc.nextLong());
            }
            Collections.sort(list, Collections.<Long>reverseOrder());
            long res=0;
            for(int i=0; i<n; i++)
            {
                long price= list.get(i)-i;
                res+= price > 0 ? price : 0;
                res=res%1000000007;
            }
            System.out.println(res);
        }
    }
}
