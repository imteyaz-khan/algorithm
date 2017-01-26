package com.sample.project.algorithm.search;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Created by imteyaz.khan on 21/01/17.
 */
public class BinarySearchTest {

    private BinarySearch bs;
    private int array[]={4,6,8,9,10,15,17,20};

    @Before
    public void setup() {
        bs=new BinarySearch();
    }
    @Test
    public void shouldFoundElementUsingDynamicProgrammingWhichIsPresentLeftSideOfArray() {
        assertTrue(bs.isPresentDynamic(8, array));
    }

    @Test
    public void shouldNotFoundElementUsingDynamicProgramming() {
        assertFalse(bs.isPresentDynamic(5, array));
    }

    @Test
    public void shouldNotFoundElementUsingDynamicProgrammingWhichIsPresentInMiddleOfArray() {
        assertTrue(bs.isPresentDynamic(10, array));
    }

    @Test
    public void shouldNotFoundElementUsingDynamicProgrammingWhichIsPresentInRightSideOfArray() {
        assertTrue(bs.isPresentDynamic(20, array));
    }

    @Test
    public void shouldFoundElementUsingRecursiveProgrammingWhichIsPresentLeftSideOfArray() {
        assertTrue(bs.isPresentRecursive(8, array));
    }

    @Test
    public void shouldNotFoundElementUsingRecursiveProgramming() {
        assertFalse(bs.isPresentRecursive(5, array));
    }

    @Test
    public void shouldNotFoundElementUsingRecursiveProgrammingWhichIsPresentInMiddleOfArray() {
        assertTrue(bs.isPresentRecursive(10, array));
    }

    @Test
    public void shouldNotFoundElementUsingRecursiveProgrammingWhichIsPresentInRightSideOfArray() {
        assertTrue(bs.isPresentRecursive(20, array));
    }
}
