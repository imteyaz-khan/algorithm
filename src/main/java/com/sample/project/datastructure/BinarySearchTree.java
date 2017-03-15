package com.sample.project.datastructure;

import com.sample.project.algorithm.Tree.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by imteyaz.khan on 22/01/17.
 */
public class BinarySearchTree<T> {

    private final Node NULL =null;
    private final Boolean TRUE=Boolean.TRUE;
    private Node<T> root;
    private Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Node getRoot() {
        return root;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public void put(T element) {
        if (root == null) {
            root=new Node(element, NULL, NULL, NULL);
        } else {
            Node<T> current=root;
            while(TRUE) {
                if(comparator.compare(element,current.getElement())>0){
                    if(current.getRight()==null) {
                        current.setRight(new Node(element,null,null,current));
                        return;
                    }
                    current=current.getRight();
                } else {
                    if(current.getLeft()==null) {
                        current.setLeft(new Node(element,null,null,current));
                        return;
                    }
                    current=current.getLeft();
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

    public void constructTreeUsingPreOrderedElement(T elements[]) {
        root=null;
        for(T element:elements) {
            put(element);
        }
    }

    private void performPreOder(Node<T> currentNode,List<T> traversedElements) {
        if(currentNode==null) {
            return;
        }
        traversedElements.add(currentNode.getElement());
        performInOrder(currentNode.getLeft(), traversedElements);
        performInOrder(currentNode.getRight(), traversedElements);
    }

    private void performInOrder(Node<T> currentNode,List<T> traversedElements) {
        if(currentNode==null) {
            return;
        }
        performInOrder(currentNode.getLeft(), traversedElements);
        traversedElements.add(currentNode.getElement());
        performInOrder(currentNode.getRight(), traversedElements);
    }

    private void performPostOrder(Node<T> currentNode,List<T> traversedElements) {
        if(currentNode==null) {
            return;
        }
        performInOrder(currentNode.getLeft(), traversedElements);
        performInOrder(currentNode.getRight(), traversedElements);
        traversedElements.add(currentNode.getElement());
    }

}
