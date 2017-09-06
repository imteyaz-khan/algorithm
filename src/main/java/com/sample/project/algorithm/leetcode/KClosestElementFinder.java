package com.sample.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by imteyaz.khan on 23/08/17.
 */
public class KClosestElementFinder {
     public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int l=0;
        int h=arr.size()-1;
        while(h-l>1) {
            int middle = l + (h - l) / 2;
            if (x > arr.get(middle)) {
                l = middle;
            } else {
                h = middle;
            }
        }

        int count=0;
        while(count<k) {
            if(l<0) {
                h++;
            } else if(h>arr.size()-1) {
                l--;
            } else if((x-arr.get(l))>(arr.get(h)-x)) {
                h++;
            } else {
                l--;
            }
            count++;
        }

        return arr.subList(l+1,l+k+1);
    }

    public static void main(String[] args) {
        Integer arr[]={1,2,3,4,5};
        List<Integer> results=findClosestElements(Arrays.asList(arr),3,4);
        for(Integer result:results) {
            System.out.print(result + " ");
        }

    }
}
