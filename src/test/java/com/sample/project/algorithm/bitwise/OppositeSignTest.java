package com.sample.project.algorithm.bitwise;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by imteyaz.khan on 19/07/17.
 */
public class OppositeSignTest {
    @Test
    public void twoPositiveNumberOppositeSignTest() {
        Assert.assertFalse(OppositeSigns.isOpposite(11,100));
    }

    @Test
    public void positiveAndNegativeNumberOppositeSignTest() {
        Assert.assertTrue(OppositeSigns.isOpposite(-11, 100));
    }

    @Test
    public void twoNegativeNumberOpposuteSignTest() {
        Assert.assertFalse(OppositeSigns.isOpposite(-11,-100));
    }
}

