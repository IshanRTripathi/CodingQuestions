package Unsolved;//Problem Question Link - https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/
/*
Given a string S, return the number of substrings of length K with no repeated characters.

Example 1:

Input: S = "havefunonleetcode", K = 5
Output: 6
Explanation:
There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
Example 2:

Input: S = "home", K = 5
Output: 0
Explanation:
Notice K can be larger than the length of S. In this case is not possible to find any substring.
*/
import java.io.*;
import java.util.*;

public class SubstringsWithNonRepeatingCharacters {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        int k= Integer.parseInt(sc.nextLine());

        System.out.println(findLengthOfNonRepeatingCharacters(s, k));
    }

    private static List<String> findLengthOfNonRepeatingCharacters(String s, int k) {
        if(k>s.length())
            return null;
        List<String> result= new ArrayList<>();
        for(int i=0; i<=s.length()-k; i++)
        {
            Set<Character> set= new HashSet<>();
            for(int j=i; j<i+k; j++)
            {
                set.add(s.charAt(j));
            }
            if(set.size()==k)
                result.add(s.substring(i, i+k));
        }
        System.out.println(result.size());
        return  result;
    }
}