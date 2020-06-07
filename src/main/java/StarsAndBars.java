/*
Question Link - hackerrank test
not a complete solution
see question in screenshots folder
*/

import java.io.IOException;

public class StarsAndBars {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        String t = "|**|*|*";//sc.nextLine();

        int[][] arr= new int[t.length()][3];
        int first=-1,  c=0;
        for(int i=0; i<t.length(); i++) {
            arr[i][0] = i+1;
            if (t.charAt(i) == '*')
            {
                c++;
            }
            else
            {
                if(first==-1)
                    first=i;
                c=0;
            }
            arr[i][1] = c;
            if(i>0)
            arr[i][2]= arr[i-1][2]+c;
        }
        for(int[] p:arr)
        {
            System.out.println(p[0]+" "+p[1]+" "+p[2]);
        }
        int li=1, ri=5;

        while(li<arr.length && arr[li++][1]!=0);
        if(li>=ri)
            System.out.println(0);
        else
        {
            while(ri>li && arr[ri--][1]!=0);
            if(ri<=li)
                System.out.println(0);
            else
                System.out.println(arr[ri][2]-arr[li][2]);
        }
        System.out.println(li+"  "+ri);
    }
}