package com.sample.project.algorithm.dynamic;

import com.sample.project.algorithm.Tree.BinaryTree;
import com.sample.project.algorithm.search.BinarySearch;
import com.sample.project.datastructure.Queue;
import com.sample.project.datastructure.Stack;

/**
 * Created by imteyaz.khan on 13/03/17.
 */
public class LeastCommonAncestor<E> {

    private BinaryTree<E> binaryTree;

    public LeastCommonAncestor(BinaryTree<E> binaryTree) {
        this.binaryTree=binaryTree;
    }

    public BinaryTree.Node getLCAWithIterative(E element1,E element2) {
            boolean status[]=new boolean[2];
            BinaryTree.Node node=getLCAWithIterative(binaryTree.getRoot(),element1,element2,status);
            if(node==null) {
                throw new RuntimeException("Either any one or both them does not exists in BT");
            }
            if(status[0] && status[1]) {
                return node;
            }
             throw new RuntimeException("No common ancestor exists");
    }

    public BinaryTree.Node getLCAWithIterative(BinaryTree.Node node,E element1,E element2,boolean status[]) {
        if(node==null) {
            return null;
        }

        if(node.getElement().equals(element1)) {
            status[0]=true;
            return node;
        }

        if(node.getElement().equals(element2)) {
            status[1]=true;
            return node;
        }

        BinaryTree.Node leftLca=getLCAWithIterative(node.getLeft(),element1,element2,status);
        BinaryTree.Node rightLca=getLCAWithIterative(node.getRight(),element1,element2,status);
        if(leftLca!=null && rightLca!=null) {
            return node;
        }

        return leftLca!=null?leftLca:rightLca;
    }




    // space complexity O(logN)+O(LogN)+ Recursive stack space
    // and time complexity O(N)+O(N) to find elements Node and then O(N) for LCA finding through while loop
    public BinaryTree.Node getLCAWithStack(E element1,E element2) {

        Stack<BinaryTree.Node> element1Path=new Stack<>();
        getNode(binaryTree.getRoot(), element1, element1Path);
        Stack<BinaryTree.Node> element2Path=new Stack<>();
        getNode(binaryTree.getRoot(), element2, element2Path);
        if(element1Path.isEmpty() || element2Path.isEmpty()) {
            throw new RuntimeException("Either any one or both them does not exists in BT");
        }
        BinaryTree.Node element1Node,elemenet2Node;
        while(!element1Path.isEmpty() && !element2Path.isEmpty()) {
            element1Node=element1Path.pop();
            elemenet2Node=element2Path.pop();
            if(element1Node==elemenet2Node) {
                return element1Node!=null?element1Node:elemenet2Node;
            }
        }
        return !element1Path.isEmpty()?element1Path.pop():element2Path.pop();
    }

    private BinaryTree.Node getNode(BinaryTree.Node node, E element,Stack path) {

        if(node==null) {
            return node;
        }
        path.push(node);
        if(node.getElement().equals(element)) {
            return node;
        }
        BinaryTree.Node childNode=getNode(node.getLeft(),element,path);
        if(childNode==null) {
            childNode=getNode(node.getRight(),element,path);
        }
        if(childNode==null) {
            path.pop();
        }
        return childNode;
    }



    private BinaryTree.Node getNode(BinaryTree.Node node, E element) {

        if(node==null) {
            return null;
        }
        if(node.getElement().equals(element)) {
            return node;
        }
        BinaryTree.Node childNode=getNode(node.getLeft(),element);
        if(childNode==null) {
            childNode=getNode(node.getRight(),element);
        }
        return childNode;
    }


    public BinaryTree.Node getNode(E element) {
        BinaryTree.Node node=getNode(binaryTree.getRoot(),element);
        if(node==null) {
            throw new RuntimeException("No node exists");
        }
        return node;
    }

    public boolean exists(E element) {
        return getNode(binaryTree.getRoot(), element) != null;
    }

    public static void main(String args[]) {
        BinaryTree<Integer> binaryTree=new BinaryTree<>();
        BinaryTree.Node node;
        BinaryTree.Node rootNode=binaryTree.put(11,null,true);
        node=binaryTree.put(6, rootNode, true);
        binaryTree.put(23, node, true);
        node=binaryTree.put(9, node, false);
        node=binaryTree.put(17,rootNode,false);
        binaryTree.put(13,node,true);
        binaryTree.put(14,node,false);
        LeastCommonAncestor leastCommonAncestor=new LeastCommonAncestor(binaryTree);
        System.out.println(leastCommonAncestor.getLCAWithStack(23,9));
        System.out.println(leastCommonAncestor.getLCAWithIterative(23,100));
    }

}
