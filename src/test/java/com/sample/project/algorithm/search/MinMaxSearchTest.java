package com.sample.project.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by imteyaz.khan on 22/01/17.
 */
public class MinMaxSearchTest {

    @Test
    public void getMin() {
        int array[]={13,17,4,6,8,9,10,15,17,20};
        MinMaxSearch minMaxSearch=new MinMaxSearch();
        assertEquals(4, minMaxSearch.getMin(array));
    }

    @Test
    public void getMinWithDuplicateValue() {
        int array[]={13,13,13,14};
        MinMaxSearch minMaxSearch=new MinMaxSearch();
        assertEquals(13,minMaxSearch.getMin(array));
    }

    @Test
    public void getMax() {
        int array[]={13,25,4,6,8,9,10,15,17,20};
        MinMaxSearch minMaxSearch=new MinMaxSearch();
        assertEquals(25,minMaxSearch.getMax(array));
    }
}
