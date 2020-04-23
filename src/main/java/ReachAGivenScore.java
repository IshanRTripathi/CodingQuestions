/*
Question Link - https://practice.geeksforgeeks.org/problems/reach-a-given-score/0
*/

import java.io.*;
import java.util.*;

public class ReachAGivenScore {
//    static Set<List<Integer>> set;
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
//            set= new HashSet<>();
            int n=sc.nextInt();
            int[] nums = new int[]{3, 5, 10};
//            calculateCombinations(n, nums, new ArrayList<>());
//            System.out.println(set);
//            System.out.println(set.size());
            int[] dp= new int[n+1];
            dp[0]=1;
            for (int num: nums ) {
                for(int i=num; i<=n; i++)
                    dp[i]+= dp[i-num];
            }
            System.out.println(dp[n]);
        }
    }
    /*static void calculateCombinations(int sum, int[] nums, List<Integer> temp) throws InterruptedException {

//        Thread.sleep(1200);
        System.out.println(sum+" : ");
        if(sum==0){
            Collections.sort(temp);
            if(!set.contains(temp)) {
                System.out.println(temp);
                set.add(temp);
            }
        }
        else
        {

            for(int i=0; i<nums.length; i++)
            {
                if(sum>0 && nums[i]<sum) {
                    sum -= nums[i];
                    temp.add(nums[i]);
//                    System.out.println(temp);
                    calculateCombinations(sum, nums, temp);
                    temp.remove(temp.size() - 1);
                    sum += nums[i];
                }
            }
        }
    }*/
}