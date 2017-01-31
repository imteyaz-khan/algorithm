package com.sample.project.algorith.sort;

import com.sample.project.algorithm.search.MergeSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * Created by imteyaz.khan on 29/01/17.
 */
public class MergeSortTest {
    @Test
    public void shouldGetSortedList() {
        Integer unsortedElements[]=new Integer[6];
        unsortedElements[0]=5;
        unsortedElements[1]=11;
        unsortedElements[2]=2;
        unsortedElements[3]=4;
        unsortedElements[4]=8;
        unsortedElements[5]=7;

        Integer expectedSortedElements[]= {2,4,5,7,8,11};

        MergeSort<Integer> mergeSort=new MergeSort<>();
        Integer sortedElements[]=mergeSort.sort(unsortedElements);
        assertEquals(expectedSortedElements,sortedElements);
    }
}
