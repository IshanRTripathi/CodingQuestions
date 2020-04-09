//Problem Question Link -

import java.io.*;
import java.util.*;

public class Solution {
    public static Map<Character, Integer>p= new HashMap<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String txt= sc.nextLine();
        String pat= sc.nextLine();

        int len= pat.length();

        Map<Character, Integer>m= new HashMap<>();
        String mat= txt.substring(0, len);
        int i=0;
        for(char ch: mat.toCharArray())
        {
            m.put(ch, m.getOrDefault(ch, 0)+1);
        }
        boolean checkFirstBlock=true;
        for(char ch: pat.toCharArray())
        {
            p.put(ch, p.getOrDefault(ch, 0)+1);
            if(!m.containsKey(ch))
                checkFirstBlock=false;
        }
        if(!checkFirstBlock)
            i+=len;

        boolean pure=true;
        for(Map.Entry<Character, Integer> entry: m.entrySet())
        {
            if(!entry.getValue().equals(p.get(entry.getKey())))
                pure=false;
        }
        if(pure)
            System.out.println(0);
        for(; i<=txt.length()-len; i++)
        {
            System.out.println(m);
            System.out.println("Testing string "+txt.substring(i, i+len)+" at "+i);
            char lastChar=txt.charAt(i-1);
            m.put(lastChar, m.getOrDefault(lastChar, +1)-1);
            char currentChar= txt.charAt(i+len-1);
            m.put(currentChar, m.getOrDefault(currentChar, 0)+1);

            if(p.get(currentChar)==null)
            {
                i+=(len-2); // len-2 because i is already incrementing + one index less we need to get to
                System.out.println("Failed for string "+txt.substring(i,i+len)+" because "+currentChar+" is not valid");
                continue;
            }
            if(m.get(currentChar)==(p.get(currentChar)))
               System.out.println(i);
            else
                System.out.println(currentChar+" is present "+m.get(currentChar)+ " times");
        }
    }
}
/*

BCDGABCDBABCD
ABCD

*/