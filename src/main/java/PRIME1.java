// https://www.spoj.com/problems/PRIME1/

import java.io.IOException;
import java.util.*;

public class PRIME1 {
    private static Set<Long> set= new HashSet<Long>();

    public static void main(String args[])throws IOException
    {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t>0)
        {
            long l=sc.nextLong();
            long r= sc.nextLong();

            for(long i=l; i<=r; i++)
            {
                if(set.contains(i) || isPrime(i)) {
                    System.out.println(i);
                    set.add(i);
                }
            }
            t--;
        }
    }

    private static boolean isPrime(long num) {
        if(set.contains(num))
            return true;
        int sqrt=(int)Math.sqrt(num);
        for(int i=2; i<=sqrt; i++)
            if(num%i==0)
                return false;
        return true;
    }
}
