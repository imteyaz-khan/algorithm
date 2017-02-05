package com.sample.project.algorithm.search;


import com.sample.project.datastructure.LinkedList;

/**
 * Created by imteyaz.khan on 04/02/17.
 */
public class SingleLinkedListCycleFinder {

    public static boolean hasCycle(LinkedList linkedList) {
        LinkedList.Node slowNode=linkedList.getHeader();
        LinkedList.Node fastNode=slowNode.getNext();
        while(slowNode!=null && fastNode!=null && fastNode.getNext()!=null) {
            if(slowNode==fastNode) {
                return true;
            }
            slowNode=slowNode.getNext();
            fastNode=fastNode.getNext().getNext();
        }
        return false;
    }

 }
