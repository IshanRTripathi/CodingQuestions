package main.java.otherCodingQuestions;

import java.util.Scanner;

//https://www.codechef.com/APRIL20B/problems/COVIDLQ
public class COVIDLQ {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();

        while(t-->0)
        {
            int n= sc.nextInt();
            int lastCheckPoint=-6;
            boolean isRuleViolated=false;
            for(int i=0; i<n; i++)
            {
                int spotType= sc.nextInt();
                if(spotType==1)
                {
                    if(i-lastCheckPoint<6)
                    {
                        isRuleViolated=true;
                    }
                    lastCheckPoint=i;
                }
            }
            if(!isRuleViolated)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}