package com.sample.project.algorithm.search;


import com.sample.project.datastructure.LinkedList;

/**
 * Created by imteyaz.khan on 04/02/17.
 */
public class SingleLinkedListCycleFinder {

    public static boolean hasCycle(LinkedList linkedList) {
        LinkedList.Node slowNode=linkedList.getHead();
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

    public static LinkedList.Node findFirstLoopNode(LinkedList linkedList) {
        LinkedList.Node slowNode=linkedList.getHead();
        LinkedList.Node fastNode=slowNode.getNext();
        while(slowNode!=null && fastNode!=null && fastNode.getNext()!=null) {
            if(slowNode==fastNode) {
                break;
            }
            slowNode=slowNode.getNext();
            fastNode=fastNode.getNext().getNext();
        }

        if(slowNode!=null && fastNode!=null && slowNode==fastNode) {
            LinkedList.Node freezNode=slowNode;
            LinkedList.Node traveller1=slowNode.getNext();
            int circleCount=1;
            while(freezNode!=traveller1) {
                traveller1=traveller1.getNext();
                circleCount++;
            }

            traveller1=linkedList.getHead();
            int count=0;
            while(count!=circleCount) {
                traveller1=traveller1.getNext();
                count++;
            }
            LinkedList.Node traveller2=linkedList.getHead();
            while(traveller1!=traveller2) {
                traveller1=traveller1.getNext();
                traveller2=traveller2.getNext();
            }

            return traveller1;
        }

        throw new IllegalArgumentException("No cycle start node exists");
    }
}
