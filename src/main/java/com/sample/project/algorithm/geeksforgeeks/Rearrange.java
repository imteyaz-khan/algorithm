package com.sample.project.algorithm.geeksforgeeks;

/**
 * Created by imteyaz.khan on 09/08/17.
 * http://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
 *
 */

public class Rearrange {

    public int[] rearrange(int arr[],int n) {
        int nextPositive=0;
        int nextNegative=0;
        while(nextNegative<n && nextPositive<n) {

            if(arr[nextPositive]<0) {
                nextPositive++;
            }
            if(arr[nextNegative]>=0) {
                nextNegative++;

            }

            if((nextPositive<n && nextNegative<n) && arr[nextPositive]>=0 && arr[nextNegative]<0) {
                int right=Math.max(nextNegative,nextPositive);
                int left=Math.min(nextNegative,nextPositive);
                int tmp=arr[right];
                System.arraycopy(arr, left + 1, arr, left + 1 + 1, right - (left + 1));
                arr[left+1]=tmp;
                nextNegative=left+2;
                nextPositive=nextNegative;
            }
        }
        return arr;
    }
    static void printArray(int arr[])
    {
        for (int anArr : arr) System.out.print(anArr + " ");
        System.out.println("");
    }
    public static void main(String[] args) {
        //int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
        //int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4};
        int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4};
        //int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4};
        //int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};

        //-5 5 -2 2 -8 4 7 1 8 0
        //int arr[] = {-5, -2, 5, 2};
        Rearrange rearrange=new Rearrange();
        printArray(arr);
        rearrange.rearrange(arr,arr.length);
        printArray(arr);
    }
}
