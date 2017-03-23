package com.sample.project.algorithm.misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by imteyaz.khan on 23/03/17.
 */
public class NumberConverterTest {
    @Test
    public void testDecimalToBaninaryConversion() {
        assertEquals("10000001",NumberConverter.getBinary(129));
    }

    @Test
    public void testBinaryToDecimalConversion() {
        assertEquals(129,NumberConverter.getDecimalFromBinary("10000001"));
    }
}
