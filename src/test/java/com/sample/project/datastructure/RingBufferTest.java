package com.sample.project.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by imteyaz.khan on 26/01/17.
 */
public class RingBufferTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldRaisedException() {
        new RingBuffer<String>(0);
    }

    @Test
    public void fillRingBuffer() throws InterruptedException {
        RingBuffer<String> ringBuffer=new RingBuffer<>(5);
        ringBuffer.add("e1");
        ringBuffer.add("e2");
        ringBuffer.add("e3");
        ringBuffer.add("e4");
        ringBuffer.add("e5");
        assertEquals(5,ringBuffer.size());
        assertFalse(ringBuffer.isEmpty());
    }


    @Test
    public void fillRingBufferAndThenEmpty() throws InterruptedException {
        RingBuffer<String> ringBuffer=new RingBuffer<>(5);
        ringBuffer.add("e1");
        ringBuffer.add("e2");
        ringBuffer.add("e3");
        ringBuffer.add("e4");
        ringBuffer.add("e5");

        ringBuffer.peak();
        ringBuffer.peak();
        ringBuffer.peak();
        ringBuffer.peak();
        ringBuffer.peak();
        assertEquals(0,ringBuffer.size());
        assertTrue(ringBuffer.isEmpty());
    }


    @Test
    public void writeReadWriteReadTest() throws InterruptedException {
        RingBuffer<String> ringBuffer=new RingBuffer<>(5);
        ringBuffer.add("e1");
        ringBuffer.add("e2");
        ringBuffer.add("e3");
        ringBuffer.add("e4");
        ringBuffer.add("e5");

        ringBuffer.peak();
        ringBuffer.peak();

        assertEquals(3,ringBuffer.size());
        assertFalse(ringBuffer.isEmpty());

        ringBuffer.add("e6");
        ringBuffer.add("e7");
        assertEquals(5,ringBuffer.size());
        assertFalse(ringBuffer.isEmpty());

        assertEquals("e3",ringBuffer.peak());
        assertEquals("e4",ringBuffer.peak());
        assertEquals("e5",ringBuffer.peak());
        assertEquals("e6",ringBuffer.peak());
        assertEquals("e7",ringBuffer.peak());

    }
}
