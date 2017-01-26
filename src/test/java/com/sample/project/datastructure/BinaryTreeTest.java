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
        BinaryTree<Integer> binaryTree=new BinaryTree<>(integerComparator);
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
        BinaryTree<Integer> binaryTree=new BinaryTree<>(integerComparator);
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
        BinaryTree<Integer> binaryTree=new BinaryTree<>(integerComparator);
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
        BinaryTree<Integer> binaryTree=new BinaryTree<>(integerComparator);
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
}
