package com.sample.project.datastructure;

/**
 * Created by imteyaz.khan on 09/09/17.
 */
public class MaxHeap {
    int nodes[];
    int count = -1;

    MaxHeap(int size) {
        nodes = new int[size];
    }

    public void add(int value) {
        if (count == nodes.length) {
            throw new IllegalArgumentException("Heap is full");
        }
        nodes[++count] = value;
        heapUp();
    }

    private void heapUp() {
        int position = count;
        int parentIndex = indexOfParent(position);
        while (parentIndex >= 0) {
            if (nodes[position] < nodes[parentIndex]) {
                break;
            }
            swap(position, parentIndex);
            position = parentIndex;
            parentIndex = indexOfParent(position);
        }
    }

    private void heapDown() {
        int position = 0;
        int leftChildIndex = indexOfLeftChild(position);
        int rightChildIndex = indexOfRightChildIndex(position);
        while (leftChildIndex <= count) {
            if (nodes[position] > nodes[leftChildIndex] && nodes[position] > nodes[rightChildIndex]) {
                break;
            } else if (nodes[position] < nodes[leftChildIndex]) {
                swap(position, leftChildIndex);
                position = leftChildIndex;
            } else {
                swap(position, leftChildIndex);
                position = rightChildIndex;
            }
            leftChildIndex = indexOfLeftChild(position);
            rightChildIndex = indexOfRightChildIndex(position);
        }
    }

    public int getMax() {
        int value = nodes[0];
        nodes[0] = nodes[count];
        nodes[count--] = Integer.MIN_VALUE;
        heapDown();
        return value;
    }

    private void swap(int position1, int position2) {
        int tmp = nodes[position1];
        nodes[position1] = nodes[position2];
        nodes[position2] = tmp;
    }

    private int indexOfLeftChild(int parent) {
        return parent * 2 + 1;
    }

    private int indexOfRightChildIndex(int parent) {
        return parent * 2 + 2;
    }

    private int indexOfParent(int childIndex) {
        return childIndex == 1 || childIndex == 2 ? 0 : childIndex / 2 - 1;
    }
}
