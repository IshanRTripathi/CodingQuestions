import java.io.*;
import java.util.*;
public class ACODE {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        while (!num.equals("0")) {
            int dp[] = new int[num.length()+1];
            dp[0] = 1;
            dp[1] = num.charAt(0) != '0' ? 1 : 0;
            for (int i = 2; i <= num.length(); i++) {
                if (num.charAt(i-1) != '0') {
                    dp[i] += dp[i - 1];
                }
                int two_digit = Integer.parseInt(num.substring(i - 2, i));

                if (two_digit >= 10 && two_digit <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            System.out.println(dp[dp.length - 1]);
            num = sc.nextLine();
        }
    }
}

        /*Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        while (true) {
            if (num.equals("0"))
                return;

            int res= decodeWays(num);
            System.out.println(res);
            num = sc.nextLine();
        }
    }

    private static int decodeWays(String num) {
        int count=0;
        int len=num.length();
        Set<String> set= new HashSet<String>();
        for(int i=0; i<len-1; i++)
        {
            /*if((i+1<num.length())) {
                if (Integer.parseInt(num.substring(i, i + 2)) <= 26) {
                    System.out.println(num.substring(i, i + 2));
                    count++;
                } else
                    System.out.println("Bigger than 26");
            }
            count++;*/
        /*int digit1= Integer.parseInt(num.substring(i, i+1));
            int digit2= Integer.parseInt(num.substring(i, i+2));
            if(digit1<10 && digit1>0) {
                StringBuilder str= new StringBuilder();
                for(int j=0; j<len; j++)
                {
                    str.append((char)('a' + Integer.parseInt(num.charAt(j)+"")-1));
                }
                System.out.println(str.toString());
                set.add(str.toString());
            }
            if(digit2>9 && digit2<=26) {
                StringBuilder str= new StringBuilder();
                for(int j=0; j<i; j++)
                {
                    str.append((char)('a' + Integer.parseInt(num.charAt(j)+"")-1));
                }
                str.append((char)('a' + digit2-1));
                for(int j=i+2; j<len; j++)
                {
                    str.append((char)('a' + Integer.parseInt(num.charAt(j)+"")-1));
                }
                System.out.println(str.toString());
                set.add(str.toString());
            }
        }
        return set.size();
    }
}
*/