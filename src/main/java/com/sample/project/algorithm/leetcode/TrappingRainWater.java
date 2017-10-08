package com.sample.project.algorithm.leetcode;

/**
 * Created by imteyaz.khan on 21/09/17.
 */
public class TrappingRainWater {
    public int trap(int height[]) {
        if(height==null|| height.length==0) {
            return 0;
        }
        int left[]=new int[height.length];
        int right[]=new int[height.length];
        left[0]=height[0];
        right[height.length-1]=height[height.length-1];

        for(int i=1;i<height.length;i++) {
            left[i]=Math.max(left[i-1],height[i]);
            right[height.length-i-1]=Math.max(right[height.length-i],height[height.length-i-1]);
        }
        int trapAmount=0;
        for(int i=1;i<height.length-1;i++) {
           int minMax=Math.min(left[i],right[i]);
            trapAmount=trapAmount+Math.max(minMax-height[i],0);
        }
        return trapAmount;
    }
}
