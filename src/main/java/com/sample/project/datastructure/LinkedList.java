package com.sample.project.datastructure;

/**
 * Created by imteyaz.khan on 04/02/17.
 */
public class LinkedList<E> {

    private Node first;
    private Node last;
    private int size=0;
    public LinkedList() {

    }

    public void add(E element) {
        if(first==null) {
            first=new Node(element);
            first.next=null;
            last=first;
        } else {
            last.next=new Node(element);
            last=last.next;
        }
        size++;
    }

    public E get(int index) {
        if(index>size-1) {
            throw new IndexOutOfBoundsException(String.format("%s out of range",index));
        }
        int count=0;
        Node currentNode=first;
        while(count<index) {
            currentNode=currentNode.next;
            count++;
        }
        return currentNode.element;
    }

    public E remove(E element) {

        if(first==null) {
            throw new IllegalArgumentException("Empty list");
        }
        Node currentNode=first;
        Node previousNode=currentNode;
        while(currentNode!=null) {
            if(currentNode.element.equals(element)) {
                previousNode.next=currentNode.next;
                size--;
                if(currentNode==first) {
                    first=currentNode.next;
                } else if(currentNode==last) {
                    last=previousNode;
                }
                return currentNode.getElement();
            }
            previousNode=currentNode;
            currentNode=currentNode.next;
        }

        throw new IllegalArgumentException("Not found");
    }



    public Node getHeader() {
        return first;
    }

    public Node getTail() {
        return last;
    }

    public class Node {
        private E element;
        private Node next;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next=next;
        }
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("element=").append(element);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }
}
