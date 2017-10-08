package com.sample.project.algorithm.leetcode;

/**
 * Created by imteyaz.khan on 07/09/17.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(k==1||nums.length==0) {
            return nums;
        }
        int results[]=new int[nums.length-k+1];
        int startIndex=0;
        int maxIndex=-1;
        while(startIndex+k-1<nums.length) {
            if(maxIndex<startIndex) {
                int max=Integer.MIN_VALUE;
                for(int i=startIndex;i<startIndex+k;i++) {
                    if(max<nums[i]) {
                        max=nums[i];
                        maxIndex=i;
                    }
                }
            } else if(nums[maxIndex]<nums[startIndex+k-1]){
                maxIndex=startIndex+k-1;
            }
            results[startIndex]=nums[maxIndex];
            startIndex++;
        }
        return results;
    }



    public static void main(String[] args) {
        int array[]={3, 2, 1, 1, 1, 5, 2, 3, 6};
        SlidingWindowMaximum slidingWindowMaximum=new SlidingWindowMaximum();
        int results[]=slidingWindowMaximum.maxSlidingWindow(array,3);
        for(int num:results) {
            System.out.print(num+",");
        }
    }
}
