package com.sample.project.datastructure;

import java.util.NoSuchElementException;

/**
 * Created by imteyaz.khan on 22/01/17.
 */
public class Queue<T> {
    private Entry head;
    private Entry last;


    public void enqueue(T element) {
        if(head==null) {
            head=new Entry(element);
            last =head;
        } else {
            last.next=new Entry(element);
            last = last.next;
        }
    }

    public T dequeue() {
        if(head==null) {
            throw new NoSuchElementException("Empty queue");
        }
        T element=head.element;
        head=head.next;
        return element;
    }

    public boolean isEmpty() {
        return head!=null;
    }

    private class Entry{
        T element;
        Entry next;

        Entry(T element) {
            this.element=element;
        }
   }
}
