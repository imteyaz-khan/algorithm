package com.sample.project.datastructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by imteyaz.khan on 23/01/17.
 */
public class AVLTree<T extends Comparable<? super T>> {
    private final Node NULL =null;
    private final Boolean TRUE=Boolean.TRUE;
    private Node root;

    public void insert(T t) {
        root=insert(t,root);
    }
    private Node insert(T t,Node node) {
        if(node==null) {
            node=new Node(t,null,null);
        } else {
            if(t.compareTo(node.element)> 0) {
                node.right=insert(t,node.right);
                if(height(node.right)-height(node.left)==2) {
                    if(t.compareTo(node.right.element)> 0) {
                        node=rightRotation(node);
                    } else {
                        node=doubleRightRotation(node);
                    }
                }
            } else {
                node.left=insert(t,node.left);
                if(height(node.left)-height(node.right)==2) {
                    if(t.compareTo(node.left.element)<0) {
                        node=leftRotation(node);
                    } else {
                        node=doubleLeftRotation(node);
                    }
                }
            }
        }
        node.height=max(height(node.left),height(node.right))+1;
        return  node;
    }

    public Node leftRotation(Node masterNode) {
        Node newMasterNode=masterNode.left;
        masterNode.left=newMasterNode.right;
        newMasterNode.right=masterNode;

        masterNode.height=max(height(masterNode.left),height(masterNode.right))+1;
        newMasterNode.height=max(height(newMasterNode.left),masterNode.height)+1;
        return newMasterNode;
    }

    public Node rightRotation(Node masterNode) {
        Node newMasterNode=masterNode.right;
        masterNode.right=newMasterNode.left;
        newMasterNode.left=masterNode;

        masterNode.height=max(height(masterNode.right),height(masterNode.left))+1;
        newMasterNode.height=max(height(newMasterNode.right),newMasterNode.left.height)+1;
        return newMasterNode;
    }

    public Node doubleLeftRotation(Node masterNode) {
        masterNode.left=rightRotation(masterNode.left);
        return leftRotation(masterNode);
    }



    public Node doubleRightRotation(Node masterNode) {
        masterNode.right=leftRotation(masterNode.right);
        return rightRotation(masterNode);
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
        System.out.println(currentNode);
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

    private int height(Node node) {
        return node==null?-1:node.height;
    }

    private int max(int a,int b) {
        return a>b?a:b;
    }



    private class Node {
        T element;
        Node left;
        Node right;
        int height;
        Node(T element, Node left, Node right) {
            this.element = element;
            this.height=0;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("element=").append(element);
            sb.append(", height=").append(height);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String args[]) {
        AVLTree<Integer> avlTree=new AVLTree<>();
        avlTree.insert(new Integer(18));
        avlTree.insert(new Integer(10));
        avlTree.insert(new Integer(5));
        avlTree.insert(new Integer(3));
        avlTree.insert(new Integer(15));
        avlTree.insert(new Integer(17));
        avlTree.insert(new Integer(2));
        avlTree.insert(new Integer(20));
        avlTree.insert(new Integer(21));
        avlTree.insert(new Integer(25));
        avlTree.insert(new Integer(23));
        avlTree.insert(new Integer(24));
        avlTree.insert(new Integer(100));
        avlTree.insert(new Integer(220));
        avlTree.insert(new Integer(88));
        avlTree.insert(new Integer(61));
        avlTree.insert(new Integer(1));
        avlTree.insert(new Integer(9));
        avlTree.insert(new Integer(40));
        avlTree.insert(new Integer(53));
        avlTree.insert(new Integer(26));
        avlTree.insert(new Integer(17));
        avlTree.insert(new Integer(11));




        List<Integer> data=avlTree.getInOrderElements();
        System.out.println(data);
    }



}
