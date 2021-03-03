package main.java.otherCodingQuestions;

import java.util.Scanner;

/*link: https://leetcode.com/explore/featured/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3625/*/
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println("Enter binary number of 32 bits");
        int n= new Scanner(System.in).nextInt();
        System.out.println(hammingWeight(n));
    }

    private static int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            if(n%10== 1)
                count++;
            n/=10;
        }
        return count;
    }
}
