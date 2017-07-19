package com.sample.project.algorithm.tree;

import com.sample.project.algorithm.misc.DisjointSet;

/**
 * Created by imteyaz.khan on 08/07/17.
 */
public class BinaryTreeMirror {

    public BinaryTree mirror(BinaryTree tree) {
        Node mirrorRootNode=mirror(tree.getRoot());
        return new BinaryTree(mirrorRootNode);
    }

    public Node mirror(Node sourceNode) {
        if(sourceNode==null) {
            return sourceNode;
        }
        Node mirror=new Node(sourceNode.getElement());
        mirror.setLeft(mirror(sourceNode.getRight()));
        mirror.setRight(mirror(sourceNode.getLeft()));
        return mirror;
    }

    public static void main(String args[]) {
        String preOrderElements[]={"A", "B","D", "E", "C", "F","M"};
        String inOrderElements[]={"D", "B", "E", "A", "F", "C","M"};
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.constructTreeUsingPreOrderAndInOrderElements(preOrderElements,inOrderElements);
        BinaryTreeMirror binaryTreeMirror=new BinaryTreeMirror();
        BinaryTree mirror=binaryTreeMirror.mirror(binaryTree);
        System.out.println(mirror.getPreOrderdElements());

    }

}
