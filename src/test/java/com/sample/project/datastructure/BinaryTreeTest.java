package com.sample.project.datastructure;

import com.sample.project.utility.IntegerComparator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * Created by imteyaz.khan on 22/01/17.
 */
public class BinaryTreeTest {
    private IntegerComparator integerComparator=new IntegerComparator();

    @Test
    public void binaryTreeInsertion() {
        BinarySearchTree<Integer> binaryTree=new BinarySearchTree<>(integerComparator);
        binaryTree.put(5);
        binaryTree.put(2);
        binaryTree.put(13);
        binaryTree.put(4);

        List<Integer> expected=new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(13);
        assertEquals(expected,binaryTree.getInOrderElements());
        binaryTree.put(9);
        expected.add(3,9);
        assertEquals(expected,binaryTree.getInOrderElements());
    }


    @Test
    public void binaryTreeInOderSearch() {
        BinarySearchTree<Integer> binaryTree=new BinarySearchTree<>(integerComparator);
        binaryTree.put(5);
        binaryTree.put(2);
        binaryTree.put(13);
        binaryTree.put(4);

        List<Integer> expected=new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(13);
        assertEquals(expected,binaryTree.getInOrderElements());
        binaryTree.put(9);
        expected.add(3,9);
        assertEquals(expected,binaryTree.getInOrderElements());
    }


    @Test
    public void binaryTreePreOderSearch() {
        BinarySearchTree<Integer> binaryTree=new BinarySearchTree<>(integerComparator);
        binaryTree.put(5);
        binaryTree.put(2);
        binaryTree.put(13);
        binaryTree.put(4);

        List<Integer> expected=new ArrayList<>();
        expected.add(5);
        expected.add(2);
        expected.add(4);
        expected.add(13);
        assertEquals(expected,binaryTree.getPreOrderdElements());
        binaryTree.put(9);
        expected.add(3,9);
        assertEquals(expected,binaryTree.getPreOrderdElements());
    }

    @Test
    public void binaryTreePostOderSearch() {
        BinarySearchTree<Integer> binaryTree=new BinarySearchTree<>(integerComparator);
        binaryTree.put(5);
        binaryTree.put(2);
        binaryTree.put(13);
        binaryTree.put(4);

        List<Integer> expected=new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(13);
        expected.add(5);



        assertEquals(expected,binaryTree.getPostOrderElements());
        binaryTree.put(9);
        expected.add(2,9);
        assertEquals(expected,binaryTree.getPostOrderElements());
    }

    @Test
    public void buildBSTUsingPreOderAndShouldSatisfyInOrder() {

        BinarySearchTree<Integer> binaryTree=new BinarySearchTree<>(integerComparator);
        Integer preOderElements[]={5, 2, 4, 9, 13};
        binaryTree.constructTreeUsingPreOrderedElement(preOderElements);

        List<Integer> expected=new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(9);
        expected.add(13);
        assertEquals(expected,binaryTree.getInOrderElements());
    }

    @Test
    public void buildBSTUsingPreOderAndShouldSatisfyPreOrder() {

        BinarySearchTree<Integer> binaryTree=new BinarySearchTree<>(integerComparator);
        Integer preOderElements[]={5, 2, 4, 9, 13};
        binaryTree.constructTreeUsingPreOrderedElement(preOderElements);

        List<Integer> expected=new ArrayList<>();
        expected.add(5);
        expected.add(2);
        expected.add(4);
        expected.add(9);
        expected.add(13);
        assertEquals(expected,binaryTree.getPreOrderdElements());
    }

    @Test
    public void buildBSTUsingPreOderAndShouldSatisfyPostOrder() {

        BinarySearchTree<Integer> binaryTree=new BinarySearchTree<>(integerComparator);
        Integer preOderElements[]={5, 2, 4, 9, 13};
        binaryTree.constructTreeUsingPreOrderedElement(preOderElements);

        List<Integer> expected=new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(9);
        expected.add(13);
        expected.add(5);
        assertEquals(expected,binaryTree.getPostOrderElements());
    }
}
