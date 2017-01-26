package com.sample.project.datastructure;

/**
 * Created by imteyaz.khan on 26/01/17.
 */
public class RingBuffer<E> {
     /* Ring buffer array;*/
    private E[] elements;

    /* Write position,will point the position in array */
    private int writePosition;

    /* Count of element which are not yet consumed */
    private int unConsumedCount;

    public RingBuffer(int size) {
        if(size < 1) {
            throw new IllegalArgumentException("Size much be greater than 0");
        }
        elements= (E[]) new Object[size];
    }


    public synchronized void add(E element) throws InterruptedException {
        while(unConsumedCount==elements.length)
            wait(0);

        elements[writePosition]=element;
        writePosition=(writePosition+1)%elements.length;
        unConsumedCount++;
        notifyAll();
    }

    public synchronized E peak() throws InterruptedException {
        while(unConsumedCount==0)
            wait();

        int readPosition=(writePosition-unConsumedCount);
        if(readPosition<0) {
            readPosition=elements.length+readPosition;
        }
        unConsumedCount--;
        E result=elements[readPosition];
        notifyAll();
        return result;
    }

    public synchronized int size() {
        return unConsumedCount;
    }

    public synchronized boolean isEmpty() {
        return unConsumedCount==0;
    }
}
