package com.sample.project.datastructure;

import com.sample.project.algorithm.Tree.BinaryTree;
import org.junit.Test;

/**
 * Created by imteyaz.khan on 15/02/17.
 */
public class BinaryTreeTest {
    @Test
    public void shouldConstructBinaryTreeUsingPreAndPostOderElements() {
//        Integer preOrderElements[]={7,10,4,3,1,2,8,11};
//        Integer inOrderElements[]={4,10,3,1,7,11,8,2};

        String preOrderElements[]={"A", "B","D", "E", "C", "F","M"};
        String inOrderElements[]={"D", "B", "E", "A", "F", "C","M"};
        BinaryTree<String> binaryTree=new BinaryTree<>();
        binaryTree.constructTreeUsingPreOrderAndInOrderElements(preOrderElements, inOrderElements);
        System.out.println(binaryTree.getPreOrderdElements());
        System.out.println(binaryTree.getInOrderElements());
    }
}
