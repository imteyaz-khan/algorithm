package com.sample.project.algorithm.search;

import com.sample.project.datastructure.Queue;
import com.sample.project.datastructure.Stack;

/**
 * Created by imteyaz.khan on 22/01/17.
 */
public class MinMaxSearch {

    public int getMin(int[] data) {
        int min=data[0];
        for(int index=1;index<data.length;index++) {
            if(min>data[index]) {
                min=data[index];
            }
        }
        return min;
    }

    public int getMax(int[] data) {
        int max=data[0];
        for(int index=0;index<data.length;index++) {
            if(max<data[index]) {
                max=data[index];
            }
        }
        return max;
    }
}
