package main.java.otherCodingQuestions;

import java.util.Scanner;

public class PatternCodingNinja {
    public static void main(String[] args) {
        int n= new Scanner(System.in).nextInt();
        for(int i=-1; i<n-1; i++){
            char ch= (char) ('A'+(i+1));
            System.out.print(ch);
            if(i>0){
                for(int j=0; j<i; j++){
                    System.out.print("*");
                }
            }
            if(i!=-1)
            System.out.print(ch);
            System.out.println();
        }
    }
}
