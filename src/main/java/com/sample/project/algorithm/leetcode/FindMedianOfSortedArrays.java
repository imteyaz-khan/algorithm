package com.sample.project.algorithm.leetcode;

/**
 * Created by imteyaz.khan on 23/08/17.
 */
public class FindMedianOfSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0) {
            return getMedian(nums2);
        } else if(nums2.length==0) {
            return getMedian(nums1);
        }
        return getMedian(nums1,nums2,0,nums1.length-1,0,nums2.length-1);
    }

    private double getMedian(int[] nums) {
        int mid=(nums.length-1)/2;
        if(nums.length%2==0) {
            return (double)(nums[mid]+nums[mid+1])/2 ;
        }
        return (double)nums[mid];
    }

    public double getMedian(int a1[],int a2[],int a1Start,int a1End,int a2Start,int a2End) {
        if(a2Start==a2End && a1Start==a1End) {
            return (double) (a1[a1Start]+a2[a2Start])/2;
        }
        else if(a2Start==a2End || a1Start==a1End) {
            int array[]=new int[2+Math.max((a1End-a1Start),(a2End-a1Start))];
            if(a2Start==a2End) {
                makeSortedArray(a1, a2[a2Start], getAppropriateIndex(a1, a1Start, a1End, a2[a2Start]), array);
            } else {
                makeSortedArray(a2, a1[a1Start], getAppropriateIndex(a2,a2Start,a2End,a1[a1Start]), array);
            }
            int mid=array.length/2;
            if(array.length%2==0) {
               return (double)(array[mid]+array[mid+1])/2 ;
            }
            return (double)array[mid];
        }

        if((a1End-a1Start)==1 && (a2End-a2Start)==1) {
            return (double)(Math.max(a1[a1Start],a2[a2Start])+Math.min(a1[a1End],a2[a2End]))/2;
        }


        int a1Middle=a1Start;
        if((a1End-a1Start) > 1){
            a1Middle=a1Start+(a1End-a1Start)/2;
        }

        int a2Middle=a2Start;
        if((a2End-a2Start)>1) {
            a2Middle=a2Start+(a2End-a2Start)/2;;
        }

        int a1MiddleElement=a1[a1Middle];
        int a2MiddleElement=a2[a2Middle];

        if(a1MiddleElement==a2MiddleElement) {
            return a1MiddleElement;
        }

        if(a1MiddleElement>a2MiddleElement) {
            a1End=a1Middle;
            a2Start=a2Middle;
        } else {
            a1Start=a1Middle;
            a2End=a2Middle;
        }


        return getMedian(a1,a2,a1Start,a1End,a2Start,a2End);
    }

    private void makeSortedArray(int[] src, int x, int appropriateIndex, int[] dest) {
        for(int index=0;index<=appropriateIndex;index++) {
            dest[index]=src[index];
        }
        dest[appropriateIndex+1]= x;
        for(int index=appropriateIndex+2;index<src.length;index++) {
            dest[index]=src[index-1];
        }

    }

    private static int getAppropriateIndex(int a[],int l,int r,int x) {
        while(r>l) {
            int m=l+(r-l)/2;
            if(a[m]==x) {
                return m;
            } else if(a[m]>x) {
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return l-1;
    }

    public static void main(String[] args) {
        int a1[]={3,4};
        int a2[]={1,2,5,6,7};
        FindMedianOfSortedArrays findMedianOfSortedArrays=new FindMedianOfSortedArrays();
       System.out.println(findMedianOfSortedArrays.findMedianSortedArrays(a1, a2));
    }


}
