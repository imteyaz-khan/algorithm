package com.sample.project.algorithm.leetcode;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imteyaz.khan on 12/09/17.
 */
public class SmallestRangeFinderTest {
    @Test
    public void shouldReturnShortestRangeSameSizeList() {
        List<Integer> range=new ArrayList<>();
        range.add(20);
        range.add(24);
        int a1[]={4,10,15,24};
        int a2[]={0,9,12,20};
        int a3[]={5,18,22,30};
        List<Integer> l1=convertArray2List(a1);
        List<Integer> l2=convertArray2List(a2);
        List<Integer> l3=convertArray2List(a3);

        List lists=new ArrayList(){{
            add(l1);
            add(l2);
            add(l3);
        }};

        SmallestRangeFinder rangeFinder=new SmallestRangeFinder();
        List<Integer> result=rangeFinder.getMinRange(lists);
        Assert.assertArrayEquals(result.toArray(),range.toArray());
    }

    @Test
    public void shouldReturnShortestRangeDiffSizeList() {
        List<Integer> range=new ArrayList<>();
        range.add(20);
        range.add(24);
        int a1[]={4,10,15,24,26};
        int a2[]={0,9,12,20};
        int a3[]={5,18,22,30};
        List<Integer> l1=convertArray2List(a1);
        List<Integer> l2=convertArray2List(a2);
        List<Integer> l3=convertArray2List(a3);

        List lists=new ArrayList(){{
            add(l1);
            add(l2);
            add(l3);
        }};

        SmallestRangeFinder rangeFinder=new SmallestRangeFinder();
        List<Integer> result=rangeFinder.getMinRange(lists);
        Assert.assertArrayEquals(result.toArray(),range.toArray());
    }


    //[[-5,-4,-3,-2,-1],[1,2,3,4,5]]

    @Test
    public void shouldReturnSortestRangeMostNegativeList() {
        List<Integer> range=new ArrayList<>();
        range.add(-1);
        range.add(1);
        int a1[]={-5,-4,-3,-2,-1};
        int a2[]={1,2,3,4,5};
        List<Integer> l1=convertArray2List(a1);
        List<Integer> l2=convertArray2List(a2);

        List lists=new ArrayList(){{
            add(l1);
            add(l2);
        }};

        SmallestRangeFinder rangeFinder=new SmallestRangeFinder();
        List<Integer> result=rangeFinder.getMinRange(lists);
        Assert.assertArrayEquals(result.toArray(),range.toArray());
    }
    private List convertArray2List(int array[]) {
        List<Integer> l=new ArrayList<>(array.length);
        for(int entry:array) {
            l.add(entry);
        }
        return l;
    }
}
