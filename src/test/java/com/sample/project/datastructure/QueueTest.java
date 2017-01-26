package com.sample.project.datastructure;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * Created by imteyaz.khan on 22/01/17.
 */
public class QueueTest {
    @Test
    public void testEnqueue() {
        Queue<Integer> queue=new Queue<>();
        queue.enqueue(1);
        queue.enqueue(3);
        assertEquals(Integer.valueOf(1),queue.dequeue());
        assertEquals(Integer.valueOf(3),queue.dequeue());
    }

    @Test
    public void testDequeue() {
        Queue<Integer> queue=new Queue<>();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals(Integer.valueOf(1),queue.dequeue());
        assertEquals(Integer.valueOf(3),queue.dequeue());
        assertEquals(Integer.valueOf(3),queue.dequeue());
        queue.enqueue(5);
        assertEquals(Integer.valueOf(4),queue.dequeue());
        assertEquals(Integer.valueOf(5),queue.dequeue());

    }

    @Test(expected = NoSuchElementException.class)
    public void shouldRaisedException() {
        Queue<Integer> queue=new Queue<>();
        queue.dequeue();
    }
}
