package main.java.otherCodingQuestions;/* package codechef; // don't place package name! */
//https://www.codechef.com/submit/GIFTSRC
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class GIFTSRC
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());

        while(t>0)
        {
            int x=0, y=0;
            int n=Integer.parseInt(sc.nextLine());
            String path= sc.nextLine();
            char ch=path.charAt(0);
            int toggle= (ch=='U' || ch=='D')?1:0;
            for(int i=0; i<path.length(); i++)
            {
                ch=path.charAt(i);
                if(toggle==1 && (ch=='U' || ch=='D'))
                {
                    if(ch=='U')
                        y++;
                    if(ch=='D')
                        y--;
                    toggle=0;
                }
                else if(toggle==0 && (ch=='L' || ch=='R'))
                {
                    if(ch=='L')
                        x--;
                    if(ch=='R')
                        x++;
                    toggle=1;
                }
            }
            System.out.println(x+" "+y);
            t--;
        }
    }
}
