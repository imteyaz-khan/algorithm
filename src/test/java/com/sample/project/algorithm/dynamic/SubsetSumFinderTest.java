package com.sample.project.algorithm.dynamic;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by imteyaz.khan on 28/02/17.
 */
public class SubsetSumFinderTest {
    @Test
    public void subsetIsNotPossible() {
        int numbers[]={1,3,5};
        SubsetSumFinder finder=new SubsetSumFinder();
        assertFalse(finder.isSumPossibleUsingDP(numbers,2));
    }

    @Test
    public void subsetSumIsPossible() {
        int numbers[]={1,3,5};
        SubsetSumFinder finder=new SubsetSumFinder();
        assertTrue(finder.isSumPossibleUsingDP(numbers, 4));
    }

    @Test
    public void subsetSumIsPossibleBaseCaseSumAsZero() {
        int numbers[]={1,3,5};
        SubsetSumFinder finder=new SubsetSumFinder();
        assertTrue(finder.isSumPossibleUsingDP(numbers,0));
    }

    @Test
    public void subsetSumIsPossibleBaseCaseWhenNoNumbers() {
        int numbers[]={};
        SubsetSumFinder finder=new SubsetSumFinder();
        assertFalse(finder.isSumPossibleUsingDP(numbers,5));
    }

}
