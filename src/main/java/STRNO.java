//https://www.codechef.com/APRIL20B/problems/STRNO
import java.io.*;
import java.util.*;
public class STRNO {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0)
        {
            int x= sc.nextInt();
            int k= sc.nextInt();
            if(x>k)
                System.out.println(0);
            else
                System.out.println(1);
        }
    }
}