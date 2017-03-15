package com.sample.project.algorithm.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by imteyaz.khan on 14/02/17.
 */
public class BinaryTree<T> {


    private final Node NULL =null;
    private Node root;

    public Node put(T element,Node node,boolean left) {
        if(root==null) {
            root=new Node(element, NULL, NULL,NULL);
            return root;
        }
        Node newNode=new Node(element, NULL, NULL,NULL);
        if(left) {
            node.left=newNode;
        } else {
            node.right=newNode;
        }
        return newNode;
    }

    public Node getRoot() {
        return root;
    }

    public void constructTreeUsingPreOrderAndInOrderElements(T preOderNodes[],T inOrderNodes[]) {
        root=buildTree(preOderNodes,inOrderNodes,0,preOderNodes.length-1,0,inOrderNodes.length-1);
    }

    private Node buildTree(T preOderNodes[],T inOrderNodes[],int preStart,int preEnd,int inStart,int inEnd) {
        if(preStart>preEnd || inStart>inEnd) {
            return null;
        }
        T element=preOderNodes[preStart];
        Node node=new Node(element,NULL,NULL,NULL);
        int index=getInOrderPosition(element,inOrderNodes)-inStart;
        node.left=buildTree(preOderNodes, inOrderNodes, preStart+1, preStart+index,inStart,inStart+index);
        node.right=buildTree(preOderNodes, inOrderNodes,preStart+index+1,preEnd,inStart+index+1,inEnd);
        return node;
    }


    public List<T> getPreOrderdElements() {
        List<T> traversedElements=new ArrayList<>();
        performPreOder(root,traversedElements);
        return traversedElements;
    }

    public List<T> getInOrderElements() {
        List<T> traversedElements=new ArrayList<>();
        performInOrder(root,traversedElements);
        return traversedElements;
    }

    private void performPreOder(Node<T> currentNode,List<T> traversedElements) {
        if(currentNode==null) {
            return;
        }
        traversedElements.add(currentNode.getElement());
        performPreOder(currentNode.getLeft(), traversedElements);
        performPreOder(currentNode.getRight(), traversedElements);
    }

    private void performInOrder(Node<T> currentNode,List<T> traversedElements) {
        if(currentNode==null) {
            return;
        }
        performInOrder(currentNode.getLeft(), traversedElements);
        traversedElements.add(currentNode.getElement());
        performInOrder(currentNode.getRight(), traversedElements);
    }

    private int getInOrderPosition(T element,T[] inOrderElement) {
        for(int index=0;index<inOrderElement.length;index++) {
            if(inOrderElement[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }

}
