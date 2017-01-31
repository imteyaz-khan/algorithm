package com.sample.project.algorithm.search;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by imteyaz.khan on 29/01/17.
 */
public class MergeSort<T extends Comparable> {

    public T[] sort(T elements[]) {
        mergeSort(elements,0,elements.length-1);
        return elements;
    }

    private void mergeSort(T elements[],int left,int right) {
        if(left<right) {
            int diff=(right-left);
            if(diff<=1) {
                return;
            }
            int center=left+diff/2;
            mergeSort(elements, left, center);
            mergeSort(elements, center+1, right);
            merge(elements,left,center,right);

        }

    }

    private void merge(T elements[],int left,int center,int right) {
        int counter=0;
        int leftCounter=left;
        int rightCounter=center+1;

        T temp[] =(T[]) Array.newInstance(Comparable.class,right-left+1);


        while(leftCounter<=center && rightCounter<=right) {
                if(elements[leftCounter].compareTo(elements[rightCounter])<0) {
                    temp[counter++]=elements[leftCounter++];
                } else {
                    temp[counter++]=elements[rightCounter++];
                }
        }

        while(leftCounter<=center) {
            temp[counter++]=elements[leftCounter++];
        }

        while(rightCounter<=right) {
            temp[counter++]=elements[rightCounter++];
        }
        System.arraycopy(temp, 0, elements, left, temp.length);
    }

}
