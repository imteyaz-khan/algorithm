package com.sample.project.datastructure;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
/**
 * Created by imteyaz.khan on 04/02/17.
 */
public class LinkedListTest {

    @Test
    public void addElementInLinkedListTest() {
        LinkedList linkedList=new LinkedList();
        linkedList.add("1");
        linkedList.add("3");
        linkedList.add("4");
        assertEquals("1",linkedList.get(0));
        assertEquals("4",linkedList.get(2));
        assertEquals("3",linkedList.get(1));
    }

    @Test
    public void removeElementFromLinklistTest() {
        LinkedList linkedList=new LinkedList();
        linkedList.add("1");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.remove("3");
        assertEquals("1",linkedList.get(0));
        assertEquals("4",linkedList.get(1));
    }

    @Test
    public void removeHeaderFromLinkListTest() {
        LinkedList linkedList=new LinkedList();
        linkedList.add("1");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.remove("1");
        assertEquals("3",linkedList.getHeader().getElement());
        assertEquals("4",linkedList.get(1));
    }

    @Test
    public void removeTailFromLinkListTest() {
        LinkedList linkedList=new LinkedList();
        linkedList.add("1");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.remove("4");
        assertEquals("1",linkedList.get(0));
        assertEquals("3",linkedList.getTail().getElement());
        linkedList.add("5");
        assertEquals("5",linkedList.getTail().getElement());
    }
}
