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
    private int vertexIndex;

    public Node put(T element,Node node,boolean left) {
        if(root==null) {
            root=new Node(element, NULL, NULL);
            return root;
        }
        Node newNode=new Node(element, NULL, NULL);
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
        Node node=new Node(element,NULL,NULL);
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

    private void performPreOder(Node currentNode,List<T> traversedElements) {
        if(currentNode==null) {
            return;
        }
        traversedElements.add(currentNode.element);
        performPreOder(currentNode.left, traversedElements);
        performPreOder(currentNode.right, traversedElements);
    }

    private void performInOrder(Node currentNode,List<T> traversedElements) {
        if(currentNode==null) {
            return;
        }
        performInOrder(currentNode.left, traversedElements);
        traversedElements.add(currentNode.element);
        performInOrder(currentNode.right, traversedElements);
    }

    private int getInOrderPosition(T element,T[] inOrderElement) {
        for(int index=0;index<inOrderElement.length;index++) {
            if(inOrderElement[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }
    public class Node {

        private T element;
        private Node left;
        private Node right;
        Node(T element, Node left, Node right) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("element=").append(element);
            sb.append('}');
            return sb.toString();
        }
    }
}
