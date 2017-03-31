package com.sample.project.algorithm.tree;

import org.junit.Test;


import static org.junit.Assert.assertTrue;
/**
 * Created by imteyaz.khan on 15/03/17.
 */
public class BinaryTreeSubTreeAlgorithmTest {
    private static final boolean LEFT=true;
    private static final boolean RIGHT=false;
    @Test
    public void testSubTreeIfSourceAndTargetIsSame() {

        BinaryTree<Integer> sourceTree=new BinaryTree<>();
        Node node;
        Node rootNode=sourceTree.put(11,null,LEFT);
        node=sourceTree.put(6, rootNode, LEFT);
        sourceTree.put(23, node, LEFT);
        sourceTree.put(9, node, RIGHT);
        node=sourceTree.put(17,rootNode,RIGHT);
        sourceTree.put(13,node,LEFT);
        sourceTree.put(14, node, RIGHT);


        BinaryTree<Integer> targetTree=new BinaryTree<>();
        rootNode=targetTree.put(11,null,LEFT);
       node=targetTree.put(6, rootNode, LEFT);
        targetTree.put(23, node, LEFT);
        targetTree.put(9, node, RIGHT);
        node=targetTree.put(17,rootNode,RIGHT);
        targetTree.put(13,node,LEFT);
        targetTree.put(15, node, RIGHT);

        BinaryTreeSubTreeAlgorithm binaryTreeSubTreeAlgorithm=new BinaryTreeSubTreeAlgorithm(sourceTree,targetTree);
        assertTrue(binaryTreeSubTreeAlgorithm.isSubTree());
    }


    @Test
    public void testSubTreeAgainstAnotherTree() {

        BinaryTree<Integer> sourceTree=new BinaryTree<>();
        Node node;
        Node rootNode=sourceTree.put(11,null,LEFT);
        node=sourceTree.put(6, rootNode, LEFT);
        node=sourceTree.put(23, node, RIGHT);
        node=sourceTree.put(17,rootNode,RIGHT);
        node=sourceTree.put(13,node,RIGHT);
        node=sourceTree.put(17,node,LEFT);
        sourceTree.put(13,node,LEFT);
        sourceTree.put(15, node, RIGHT);

        BinaryTree<Integer> targetTree=new BinaryTree<>();
        rootNode=targetTree.put(17, null, LEFT);
        targetTree.put(13,rootNode,LEFT);
        targetTree.put(15, rootNode, RIGHT);

        BinaryTreeSubTreeAlgorithm binaryTreeSubTreeAlgorithm=new BinaryTreeSubTreeAlgorithm(sourceTree,targetTree);
        assertTrue(binaryTreeSubTreeAlgorithm.isSubTree());
    }
}
