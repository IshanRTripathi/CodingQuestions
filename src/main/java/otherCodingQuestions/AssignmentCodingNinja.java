package main.java.otherCodingQuestions;

import java.util.Scanner;

public class AssignmentCodingNinja {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int b= sc.nextInt();
        int m= sc.nextInt();

        solve(n, b, m);
    }

    public static void solve(int n, int b, int m) {
        int time=0;int solved=0;
        while(n>0) {
            if (n % 2 == 0) {
                solved= (n / 2);
                n -= solved;
                time += (m * solved);
            } else {
                solved = ((n + 1) / 2);
                time += (m * solved);
                n -= solved;
            }
            m *= 2;
            time += b;
        }
        System.out.println(time-b);
    }
}
