package com.sample.project.algorithm.tree;

/**
 * Created by imteyaz.khan on 15/03/17.
 */
public class BinaryTreeSubTreeAlgorithm {
    private BinaryTree sourceTree;
    private BinaryTree targetTree;

    public BinaryTreeSubTreeAlgorithm(BinaryTree sourceTree, BinaryTree targetTree) {
        this.sourceTree = sourceTree;
        this.targetTree = targetTree;
    }

    public boolean isSubTree() {
        return isSubTreeOf(sourceTree.getRoot(), targetTree.getRoot());
    }

    private boolean isSubTreeOf(Node sourceNode, Node targetNode) {
        if ((sourceNode == null || targetNode == null) && (sourceNode != targetNode)) {
            return false;
        }
        if (isSimilarTree(sourceNode, targetNode, 0)) {
            return true;
        }

        return isSubTreeOf(sourceNode.getLeft(), targetNode)||isSubTreeOf(sourceNode.getRight(), targetNode);
    }

    private boolean isSimilarTree(Node sourceNode, Node targetNode, int level) {
        if (sourceNode == null && targetNode == null) {
            return true;
        }

        if (sourceNode != null && targetNode != null) {
            if (sourceNode.getElement().equals(targetNode.getElement())) {
                return isSimilarTree(sourceNode.getLeft(), targetNode.getLeft(), level + 1) &&
                        isSimilarTree(sourceNode.getRight(), targetNode.getRight(), level + 1);
            } else if(level>0) {
                return isSubTreeOf(sourceNode,targetTree.getRoot());
            }
        }
        return false;
    }

}
