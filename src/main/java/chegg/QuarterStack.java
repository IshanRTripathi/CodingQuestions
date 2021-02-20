package main.java.chegg;

import java.util.Scanner;

public class QuarterStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();
        quarterStack(input);

        // test input
        quarterStack("sm");
        quarterStack("Apples");
        quarterStack("Apples are great!");
    }

    private static void quarterStack(String val) {
        if(val.length()<4){
            System.out.println("To Small of a String:"+val+" for QuarterStack!");
            return;
        }
        int rem= val.length()%4;
        int eachStringLength= val.length()/4;
        String[] res= new String[4];

        int start=0, end= 0;
        for(int i=0; i<4; i++){
            start= end;
            if(i<= 4-rem-1) {
                end= end+ eachStringLength;
            }
            else{
                end= end+ eachStringLength+1;
            }
            res[i]= val.substring(start, end);
        }
        for(String str: res){
            System.out.println(str);
        }
    }
}
