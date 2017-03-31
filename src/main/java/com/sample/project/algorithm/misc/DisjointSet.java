package com.sample.project.algorithm.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imteyaz.khan on 26/03/17.
 */
public class DisjointSet<E> {

    private Map<E,Node> map;

    public DisjointSet() {
        this.map=new HashMap<>();
    }


    public Node makeSet(E e) {
        Node node = new Node(e);
        node.setParent(node);
        map.put(e,node);
        return node;
    }

    public Node union(E e1,E e2) {
        Node node1=map.get(e1);
        Node node2=map.get(e2);
        node1=findSet(node1);
        node2=findSet(node2);
        if(node1==node2) {
            return merge(node1,node2);
        } else {
            if(node1.getRank()>=node2.getRank()) {
                return merge(node1,node2);
            } else {
                return merge(node2,node1);
            }
        }
    }

    private Node merge(Node main,Node child) {
        main.setParent(child);
        main.setRank(main.getRank()+child.getRank()+1);
        return main;
    }

    public Node findSet(E e) {
        return map.get(e).getParent();
    }

    private Node findSet(Node node) {
        Node parent=map.get(node.getElement()).getParent();
        if(parent==node) {
            return node;
        }
        node.setParent(findSet(parent));
        return node.getParent();
    }

    public class Node {
        private Node parent;
        private E element;
        private int rank;

        public Node(E element) {
            this.element = element;
            this.rank=0;
        }

        public E getElement() {
            return element;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getParent() {
            return parent;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

    public static void main(String args[]) {
        DisjointSet<Integer> disjointSet= new DisjointSet<>();

        disjointSet.makeSet(1);
        disjointSet.makeSet(2);
        disjointSet.makeSet(3);
        disjointSet.makeSet(4);
        disjointSet.makeSet(5);
        disjointSet.makeSet(6);
        disjointSet.makeSet(7);

        disjointSet.union(1,2);
        disjointSet.union(3,4);
        disjointSet.union(4,5);
        disjointSet.union(3,7);
        disjointSet.union(6,7);
        disjointSet.union(5,7);

        DisjointSet.Node node=disjointSet.findSet(4);
        System.out.println(node.getElement());
    }
}
