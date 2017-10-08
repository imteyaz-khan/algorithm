package com.sample.project.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by imteyaz.khan on 21/09/17.
 */
public class TrappingRainWaterTest {
    @Test
    public void getTrapWaterWhereTwoZeroLevel() {
        int height[]={0,1,0,2};
        TrappingRainWater trw=new TrappingRainWater();
        Assert.assertEquals(1,trw.trap(height));
    }

    @Test
    public void getTrapWaterWithMoreSamplel() {
        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trw=new TrappingRainWater();
        Assert.assertEquals(6,trw.trap(height));
    }
}
