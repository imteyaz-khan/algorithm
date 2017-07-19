package com.sample.project.algorithm.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imteyaz.khan on 11/07/17.
 */
public class FIndIndices {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int length=nums.length;
        int indices[]=new int[2];
        for(int index=0;index<length;index++) {
            if(map.containsKey(target - nums[index])) {
                indices[0]=map.get(target-nums[index]);
                indices[1]=index;
            } else {
                map.put(nums[index],index);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int nums[]={4,5,1,3};
        int indices[]=twoSum(nums,71);
        System.out.println(indices[0]+"::"+indices[1]);
    }
}
