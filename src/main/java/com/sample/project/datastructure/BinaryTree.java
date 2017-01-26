package com.sample.project.datastructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by imteyaz.khan on 22/01/17.
 */
public class BinaryTree<T> {

    private final Node NULL =null;
    private final Boolean TRUE=Boolean.TRUE;
    private Node root;
    private Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void put(T element) {
        if (root == null) {
            root=new Node(element, NULL, NULL, NULL);
        } else {
            Node current=root;
            while(TRUE) {
                if(comparator.compare(element,current.element)>0){
                    if(current.right==null) {
                        current.right=new Node(element,null,null,current);
                        return;
                    }
                    current=current.right;
                } else {
                    if(current.left==null) {
                        current.left=new Node(element,null,null,current);
                        return;
                    }
                    current=current.left;
                }
            }
        }
    }


    public  List<T> getPreOrderdElements() {
        List<T> traversedElements=new ArrayList<>();
        performPreOder(root,traversedElements);
        return traversedElements;
    }

    public List<T> getInOrderElements() {
        List<T> traversedElements=new ArrayList<>();
        performInOrder(root,traversedElements);
        return traversedElements;
    }

    public List<T> getPostOrderElements() {
        List<T> traversedElements=new ArrayList<>();
        performPostOrder(root, traversedElements);
        return traversedElements;
    }

    private void performPreOder(Node currentNode,List<T> traversedElements) {
        if(currentNode==null) {
            return;
        }
        traversedElements.add(currentNode.element);
        performInOrder(currentNode.left, traversedElements);
        performInOrder(currentNode.right, traversedElements);
    }

    private void performInOrder(Node currentNode,List<T> traversedElements) {
        if(currentNode==null) {
            return;
        }
        performInOrder(currentNode.left, traversedElements);
        traversedElements.add(currentNode.element);
        performInOrder(currentNode.right, traversedElements);
    }

    private void performPostOrder(Node currentNode,List<T> traversedElements) {
        if(currentNode==null) {
            return;
        }
        performInOrder(currentNode.left, traversedElements);
        performInOrder(currentNode.right, traversedElements);
        traversedElements.add(currentNode.element);
    }


    private class Node {

        T element;
        Node left;
        Node right;
        Node parent;

        Node(T element, Node left, Node right, Node parent) {
            this.element = element;
        }
    }
}
