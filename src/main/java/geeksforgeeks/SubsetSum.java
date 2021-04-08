package main.java.geeksforgeeks;

import java.io.*;
import java.util.*;
/*
Link:
Input:
1
5
1 2 3 4 5
* */
class SubsetSum
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        t= 1;
        while(t-- > 0)
        {
            int N=sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0; i < N ; i++){
                arr.add(sc.nextInt());
            }
            FindAllSubsetSum ob = new FindAllSubsetSum();

            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }
    }
}
class FindAllSubsetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> res= new ArrayList<Integer>();
        recur(res, arr, 0, 0);
        Collections.sort(res);
        return res;
    }

    void recur(ArrayList<Integer> res, ArrayList<Integer> arr, int sumSoFar, int index){
        if(index == arr.size()){
            //if(!res.contains(sumSoFar))
            res.add(sumSoFar);
            return;
        }

        for(int i=index; i<arr.size(); i++){
            recur(res, arr, sumSoFar, i+1); // not picked
            sumSoFar+= arr.get(i);
            recur(res, arr, sumSoFar, i+1); // picked
            sumSoFar-= arr.get(i);
        }
    }
}