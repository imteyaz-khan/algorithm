package com.sample.project.algorithm.tree;

import com.sample.project.datastructure.BinarySearchTree;
import com.sample.project.utility.IntegerComparator;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

/**
 * Created by imteyaz.khan on 14/03/17.
 */
public class BSTSubTreeAlgorithmTest {
    private IntegerComparator integerComparator=new IntegerComparator();

    @Test
    public void subTreeExistsTest() {
        BinarySearchTree<Integer> sourceBinaryTree=new BinarySearchTree<>(integerComparator);
        sourceBinaryTree.put(10);
        sourceBinaryTree.put(7);
        sourceBinaryTree.put(9);
        sourceBinaryTree.put(8);
        sourceBinaryTree.put(5);
        sourceBinaryTree.put(5);
        sourceBinaryTree.put(6);
        sourceBinaryTree.put(3);
        sourceBinaryTree.put(2);
        sourceBinaryTree.put(1);

        sourceBinaryTree.put(13);
        sourceBinaryTree.put(18);
        sourceBinaryTree.put(14);

        BinarySearchTree<Integer> targetBinaryTree=new BinarySearchTree<>(integerComparator);
        targetBinaryTree.put(5);
        targetBinaryTree.put(3);
        targetBinaryTree.put(2);
        targetBinaryTree.put(1);

        BinarySearchSubTreeAlgorithm subTreeAlgorithm=new BinarySearchSubTreeAlgorithm(sourceBinaryTree,targetBinaryTree);
        assertTrue(subTreeAlgorithm.isSubTree());
    }

    @Test
    public void subTreeExistIfBothTreeAreSame() {
        BinarySearchTree<Integer> sourceBinaryTree=new BinarySearchTree<>(integerComparator);
        sourceBinaryTree.put(10);
        sourceBinaryTree.put(7);
        sourceBinaryTree.put(9);
        sourceBinaryTree.put(8);
        sourceBinaryTree.put(5);
        sourceBinaryTree.put(5);
        sourceBinaryTree.put(6);
        sourceBinaryTree.put(3);
        sourceBinaryTree.put(2);
        sourceBinaryTree.put(1);
        sourceBinaryTree.put(13);
        sourceBinaryTree.put(18);
        sourceBinaryTree.put(14);

        BinarySearchTree<Integer> targetBinaryTree=new BinarySearchTree<>(integerComparator);
        targetBinaryTree.put(10);
        targetBinaryTree.put(7);
        targetBinaryTree.put(9);
        targetBinaryTree.put(8);
        targetBinaryTree.put(5);
        targetBinaryTree.put(5);
        targetBinaryTree.put(6);
        targetBinaryTree.put(3);
        targetBinaryTree.put(2);
        targetBinaryTree.put(1);

        targetBinaryTree.put(13);
        targetBinaryTree.put(18);
        targetBinaryTree.put(14);

        BinarySearchSubTreeAlgorithm subTreeAlgorithm=new BinarySearchSubTreeAlgorithm(sourceBinaryTree,targetBinaryTree);
        assertTrue(subTreeAlgorithm.isSubTree());
    }
}
