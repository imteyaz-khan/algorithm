package com.sample.project.algorithm.misc;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by imteyaz.khan on 03/05/17.
 */
public class EqualSumSubArrayProblemTest {

    @Test
    public void hasPartitionKeyTest() {
        EqualSumSubArrayProblem pp=new EqualSumSubArrayProblem();
        int numbers[]={1,1,2,3,5};
        assertTrue(pp.hasPartition(numbers));
    }

}
