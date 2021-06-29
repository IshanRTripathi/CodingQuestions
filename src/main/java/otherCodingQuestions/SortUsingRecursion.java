package main.java.otherCodingQuestions;

import java.util.Arrays;

public class SortUsingRecursion {
    public static void main(String[] args) {
        int[] arr= {4,6,1,9,11,3,0};
//        Arrays.stream(arr).forEach(System.out::println);
        new SortUsingRecursion().sort(arr, arr.length-1);
//        Arrays.stream(arr).forEach(System.out::println);
    }

    private void sort(int[] arr, int i) {
        if(i==0){
            return;
        }
        sort(arr, i-1);

        // iterate and insert element at appropriate place, this
        // can also be implemented using recursion
        for(int itr=0; itr<i; itr++){
//            System.out.println("\n\nFor i= "+i);
//            Arrays.stream(arr).forEach(System.out::print);
            if(arr[itr]<arr[i]){
//                System.out.println("\tswapping: "+arr[itr]+" and "+arr[i]);
                int temp= arr[itr];
                arr[itr]= arr[i];
                arr[i]=temp;
            }
        }
    }
}
