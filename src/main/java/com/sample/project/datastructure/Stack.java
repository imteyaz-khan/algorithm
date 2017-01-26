package com.sample.project.datastructure;

import java.util.EmptyStackException;

/**
 * Created by imteyaz.khan on 21/01/17.
 */
public class Stack<T> {
    private Entry<T> current;

    public T pop() {
        if(current!=null) {
            T currentElement=current.getElement();
            current=current.getPrevious();
            return currentElement;
        }
        throw new EmptyStackException();
    }

    public void push(T element) {
        current=new Entry<>(element,current);
    }


    class Entry<T> {
        Entry previous;
        T element;

        public Entry(T element,Entry previous) {
            this.element=element;
            this.previous=previous;
        }

        private T getElement() {
            return element;
        }

        private Entry getPrevious() {
            return this.previous;
        }
    }



}
