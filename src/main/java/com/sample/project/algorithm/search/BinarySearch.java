package com.sample.project.algorithm.search;


public class BinarySearch {

    private static final boolean PRESENT=Boolean.TRUE;
    private static final boolean ABSENT=!PRESENT;


    public boolean isPresentDynamic(int value,int data[]) {
        int binarySearchStartIndex=0;
        int binarySearchEndIndex=data.length;

        while((binarySearchStartIndex<binarySearchEndIndex)) {
            int elementIndex=(binarySearchStartIndex+binarySearchEndIndex)/2;
            int elementIndexedValue=data[elementIndex];
            if(elementIndexedValue==value) {
                return PRESENT;
            } else if(elementIndexedValue<value){
                binarySearchStartIndex=elementIndex+1;
            } else {
                binarySearchEndIndex=elementIndex-1;
            }
        }
        return ABSENT;
    }

    public boolean isPresentRecursive(int value,int data[]) {
        if(data.length==0) {
            return ABSENT;
        }
        int elementIndex=(0+data.length)/2;
        int elementIndexedValue=data[elementIndex];

        if(elementIndexedValue==value) {
            return PRESENT;
        } else if(elementIndexedValue<value){
            int subData[]=new int[data.length-(elementIndex+1)];
            System.arraycopy(data,elementIndex+1,subData,0,(data.length-(elementIndex+1)));
            return isPresentRecursive(value,subData);
        } else {
            int subData[]=new int[elementIndex-1];
            System.arraycopy(data,0,subData,0,elementIndex-1);
            return isPresentRecursive(value,subData);
        }
    }

}
