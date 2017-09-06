package com.sample.project.algorithm.misc;

import java.util.Arrays;

/**
 * Created by imteyaz.khan on 19/08/17.
 * problem statement can be found here
 * https://www.quora.com/Given-a-zero-indexed-array-A-1-2-3-n-of-n-integers-how-can-we-re-arrange-the-numbers-in-it-such-that-for-any-two-numbers-a-i-and-a-j-i-j-their-average-does-not-lie-between-i-and-j
 */

public class NonAvgNumberArrangement {

    public int[] rearrange(int range) {
        int numbers[]=new int[range];
        for(int index=1;index<=range;index++) {
            numbers[index-1]=index;
        }
        return rearrange(numbers);
    }

    private int[] rearrange(int numbers[]) {
        if(numbers.length<=2) {
            return numbers;
        }
        int length=numbers.length;
        int odd[];
        int even[]=new int[length/2];
        if(length%2==1) {
            odd=new int[length/2+1];
        } else {
            odd=new int[length/2];
        }
        int evenCounter=0;
        int oddCounter=0;
        for(int index=1;index<=length;index++) {
            if(index%2==0) {
                even[evenCounter++]=numbers[index-1];
            } else {
                odd[oddCounter++]=numbers[index-1];
            }
        }
        int[] arr1=rearrange(odd);
        int[] arr2=rearrange(even);

        int merged[]=new int[arr1.length+arr2.length];
        copy(arr1,merged,0);
        copy(arr2,merged,arr1.length);
        return merged;
    }
    // 1 3 5 7 9     2 4 6 10
    private void copy(int[] source,int destination[],int position) {
        for(int index=0;index<source.length;index++) {
            destination[position+index]=source[index];
        }
    }

    public static void main(String[] args) {
        NonAvgNumberArrangement nonAvgNumberArrangement=new NonAvgNumberArrangement();
        int numbers[]=nonAvgNumberArrangement.rearrange(5);
        for(int index=0;index<numbers.length;index++) {
            System.out.print(numbers[index]+" ");
        }
    }

}
