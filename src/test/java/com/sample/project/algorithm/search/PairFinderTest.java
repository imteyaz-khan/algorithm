package com.sample.project.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by imteyaz.khan on 05/04/17.
 */
public class PairFinderTest {

    @Test
    public void hasPairInSortedArray() {
        int a[]={1,2,3,5,7};
        PairFinder finder=new PairFinder();
        assertTrue(finder.hasPairWithSortedArray(a, 7));
    }

    @Test
    public void hasPairInSortedArrayShouldFail() {
        int a[]={1,2,3,7};
        PairFinder finder=new PairFinder();
        assertFalse(finder.hasPairWithSortedArray(a, 6));
    }


    @Test
    public void hasPairInUnSortedArray() {
        int a[]={5,0,3,7};
        PairFinder finder=new PairFinder();
        assertTrue(finder.hasPairUnSortedArray(a, 7));
    }

    @Test
    public void hasPairInUnSortedArrayShouldFail() {
        int a[]={1,2,3,7};
        PairFinder finder=new PairFinder();
        assertFalse(finder.hasPairUnSortedArray(a, 6));
    }

}
