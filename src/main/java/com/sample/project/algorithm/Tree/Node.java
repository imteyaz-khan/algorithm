package com.sample.project.algorithm.tree;

/**
 * Created by imteyaz.khan on 15/03/17.
 */
public class Node<T> {

    T element;
    Node left;
    Node right;
    Node parent;

    public Node(T element, Node left, Node right, Node parent) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("element=").append(element);
        sb.append('}');
        return sb.toString();
    }
}
