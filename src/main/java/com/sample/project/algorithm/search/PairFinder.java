package com.sample.project.algorithm.search;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by imteyaz.khan on 05/04/17.
 */
public class PairFinder {

    public boolean hasPairWithSortedArray(int a[],int sum) {
        int lowerCounter=0;
        int upperCounter=a.length-1;
        while(lowerCounter<upperCounter) {
            int currentSum=a[lowerCounter]+a[upperCounter];
            if(currentSum==sum) {
                return true;
            } else if(currentSum < sum) {
                    lowerCounter++;
            } else {
                upperCounter--;
            }
        }
        return false;
    }

    public boolean hasPairUnSortedArray(int a[],int sum) {

        Set<Integer> subtractedValues=new HashSet<>(a.length-1);
        for(int index=0;index<a.length;index++) {
            int currentValue=a[index];
            if(subtractedValues.contains(currentValue)) {
                return true;
            }
            subtractedValues.add(sum-currentValue);
        }
        return false;
    }

}
