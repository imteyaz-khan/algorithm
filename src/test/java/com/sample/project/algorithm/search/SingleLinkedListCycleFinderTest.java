package com.sample.project.algorithm.search;

import com.sample.project.datastructure.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by imteyaz.khan on 04/02/17.
 */
public class SingleLinkedListCycleFinderTest {

    @Test
    public void hasNoCycleTest() {

        LinkedList linkedList=new LinkedList();
        linkedList.add("1");
        linkedList.add("3");
        linkedList.add("4");

        assertFalse(SingleLinkedListCycleFinder.hasCycle(linkedList));
    }


    @Test
    public void haCycleTest() {

        LinkedList linkedList=new LinkedList();
        linkedList.add("1");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");
        linkedList.add("8");
        linkedList.add("9");
        linkedList.add("20");

        LinkedList.Node last=linkedList.getTail();
        last.setNext(linkedList.getHeader().getNext().getNext().getNext());
        assertTrue(SingleLinkedListCycleFinder.hasCycle(linkedList));
    }
}
