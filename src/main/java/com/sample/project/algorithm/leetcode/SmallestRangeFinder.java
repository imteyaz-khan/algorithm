package com.sample.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by imteyaz.khan on 12/09/17.
 */
public class SmallestRangeFinder {
    public List<Integer> getMinRange(final List<List<Integer>> arrays) {
        if(arrays==null || arrays.size()==0) {
            return null;
        }
        if(arrays.size()==1) {
            return arrays.get(0).size()==0?null:new ArrayList() {{
                add(arrays.get(0).get(0));
            }};
        }
        PriorityQueue<Wrapper> priorityQueue=new PriorityQueue<>(arrays.size());
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int index=0;index<arrays.size();index++) {
            int value=arrays.get(index).get(0);
            min=Math.min(min,value);
            max=Math.max(max,value);
            priorityQueue.add(new Wrapper(value,0,index));
        }
        int curMax=max;
        while(!priorityQueue.isEmpty()) {
            Wrapper polled=priorityQueue.poll();
            if((polled.getValue()>=min && curMax>=max) && (Math.abs(curMax-polled.getValue())<Math.abs(max-min))) {
                min=polled.getValue();
                max=curMax;
            }
            int nextReadPosition=polled.getPosition()+1;
            if(arrays.get(polled.getListId()).size()==nextReadPosition) {
                break;
            }
            int value=arrays.get(polled.getListId()).get(nextReadPosition);
            priorityQueue.add(new Wrapper(value,nextReadPosition,polled.getListId()));
            curMax=Math.max(curMax,value);
        }
        List<Integer> result=new ArrayList<>();
        result.add(min);
        result.add(max);
        return result;
    }

    class Wrapper implements Comparable<Wrapper>{
        private int position;
        private int listId;
        private int value;

        Wrapper(int value, int position, int listId) {
            this.position = position;
            this.listId = listId;
            this.value=value;
        }

        public int getValue() {
            return value;
        }

        public int getPosition() {
            return position;
        }

        public int getListId() {
            return listId;
        }

        @Override
        public int compareTo(Wrapper o) {
            return Integer.valueOf(value).compareTo(o.value);
        }
    }
}
