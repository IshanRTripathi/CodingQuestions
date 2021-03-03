package main.java.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class EqualSumArrayWithMinimumOperations {

    public static void main(String[] args) {
        int[] nums1= new int[]{1,2,3,4,5,6};
        int[] nums2= new int[]{1,1,2,2,2,2};

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum1=0, sum2=0;
        for(int x: nums1){
            sum1+=x;
        }

        sum1= nums1.length*6 - sum1;
        sum2= nums2.length*6 - sum2;
        for(int x: nums2){
            sum2+=x;
        }
        int count=0;
        int diff= Math.abs(sum1-sum2);
        while(diff>0){
            count++;
            if(sum1>sum2){

            }
            else if(sum1<sum2){
                int maxIndex= getMaxIndex(nums2);
                System.out.println("Replacing ");
            }
        }

    }

    private static int getMaxIndex(int[] nums) {
        int max=0, index=0;
        for(int i=0; i<nums.length; i++){
            if(max<nums[i]) {
                index = i;
                max= nums[i];
            }
        }
        return index;
    }
}
