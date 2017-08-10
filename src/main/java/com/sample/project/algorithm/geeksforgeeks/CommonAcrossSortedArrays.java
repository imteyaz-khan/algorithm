package com.sample.project.algorithm.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imteyaz.khan on 10/08/17.
 */
public class CommonAcrossSortedArrays {
    public Integer[] findCommons(int a1[], int a2[], int a3[]) {
        List<Integer> common=new ArrayList<>();
        int i=0,j=0,k=0;
        while(i<a1.length && j<a2.length && k<a3.length) {
            if(a1[i]==a2[j] && a2[j]==a3[k]) {
                common.add(a1[i]);
                i++;
                j++;
                k++;
            } else if(a1[i] < a2[j]) {
                i++;
            } else if(a2[j] <a3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return common.stream().map(Integer::intValue).toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        int a1[] = {1, 5, 10, 20, 40, 80};
        int a2[] = {6, 7, 20, 80, 100};
        int a3[] = {3, 4, 15, 20, 30, 70, 80, 120};
        CommonAcrossSortedArrays commonAcrossSortedArrays=new CommonAcrossSortedArrays();
        Integer[] commons=commonAcrossSortedArrays.findCommons(a1,a2,a3);
        for(Integer value:commons) {
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("\n");
    }
}
