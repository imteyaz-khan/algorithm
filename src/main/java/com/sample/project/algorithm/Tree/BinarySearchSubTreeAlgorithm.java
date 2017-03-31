package com.sample.project.algorithm.tree;

import com.sample.project.datastructure.BinarySearchTree;

/**
 * Created by imteyaz.khan on 14/03/17.
 */
public class BinarySearchSubTreeAlgorithm<T> {

    private BinarySearchTree<T> sourceTree;
    private BinarySearchTree<T> targetTree;

    public BinarySearchSubTreeAlgorithm(BinarySearchTree<T> sourceTree, BinarySearchTree<T> targetTree) {
        this.sourceTree=sourceTree;
        this.targetTree=targetTree;
    }
    public boolean isSubTree() {
        return isSubTreeOfBST(sourceTree.getRoot(),targetTree.getRoot());
    }

    private boolean isSubTreeOfBST(Node<T> sourceNode,Node<T> targetNode) {
        if((sourceNode==null||targetNode==null ) && (sourceNode!=targetNode)) {
            return false;
        }
        if(isSimilarBST(sourceNode, targetNode,0)) {
            return true;
        }
        if(sourceTree.getComparator().compare(sourceNode.getElement(),targetNode.getElement())>=0) {
            return isSubTreeOfBST(sourceNode.getLeft(), targetNode);
        } else {
            return isSubTreeOfBST(sourceNode.getRight(), targetNode);
        }
    }

    private boolean isSimilarBST(Node<T> sourceNode,Node<T> targetNode,int levelMatch) {
        if(sourceNode==null && targetNode==null) {
            return true;
        }
        if(sourceNode==null||targetNode==null) {
            return false;
        }
        if(sourceNode.getElement().equals(targetNode.getElement())) {
            return isSimilarBST(sourceNode.getLeft(), targetNode.getLeft(),levelMatch+1) && isSimilarBST(sourceNode.getRight(), targetNode.getRight(),levelMatch+1);
        } else if(levelMatch>0){
            return isSubTreeOfBST(sourceNode, targetTree.getRoot());
        }
        return false;
    }
}
