package com.sample.project.algorithm.tree;

import com.sample.project.datastructure.Queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by imteyaz.khan on 09/07/17.
 */
public class BinaryTreeTopView {


    public static List<String> getTopViewEleements(BinaryTree<String> binaryTree) {
        List<String> elements = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<LevelInfo> queue = new Queue<>();
        queue.enqueue(new LevelInfo(binaryTree.getRoot(), 0));
        while (queue.isEmpty()) {
            LevelInfo levelInfo = queue.dequeue();
            if (!visited.contains(levelInfo.distance)) {
                visited.add(levelInfo.distance);
                elements.add((String) levelInfo.node.getElement());
            }
            if (levelInfo.node.getLeft() != null) {
                queue.enqueue(new LevelInfo(levelInfo.node.getLeft(), levelInfo.distance - 1));
            }
            if (levelInfo.node.getRight() != null) {
                queue.enqueue(new LevelInfo(levelInfo.node.getRight(), levelInfo.distance + 1));
            }

        }
        return elements;
    }

    static class LevelInfo<T> {
        private Node node;
        private int distance;

        public LevelInfo(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    /*
     1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6
     */
    public static void main(String[] args) {
        String preOrderElements[] = {"A", "B", "D", "E", "C", "F", "M"};
        String inOrderElements[] = {"D", "B", "E", "A", "F", "C", "M"};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.constructTreeUsingPreOrderAndInOrderElements(preOrderElements, inOrderElements);
        System.out.println(getTopViewEleements(binaryTree));
    }
}
