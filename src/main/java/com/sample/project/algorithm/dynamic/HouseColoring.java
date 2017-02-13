package com.sample.project.algorithm.dynamic;

/**
 * Created by imteyaz.khan on 12/02/17.
 */
public class HouseColoring {

    public static int minCostWithThreeColor(int cost[][]) {
        int length=cost.length;
        if(length==1) {
            return getMin(cost[0]);
        }
        for(int index=1;index<cost.length;index++) {
            cost[index][0]=Math.min(cost[index-1][1],cost[index-1][2])+cost[index][0];
            cost[index][1]=Math.min(cost[index-1][0],cost[index-1][2])+cost[index][1];
            cost[index][2]=Math.min(cost[index-1][0],cost[index-1][1])+cost[index][2];
        }
        return getMin(cost[cost.length-1]);
    }

    public static int minCostWithNColor(int cost[][]) {
        int length=cost.length;
        if(length==1) {
            return getMin(cost[0]);
        }
        for(int i = 1; i<cost.length;i++) {
            for(int j = 0; j<cost[0].length;j++) {
                cost[i][j]=getMinExcept(cost[i-1],j)+cost[i][j];
            }
        }
        return getMin(cost[cost.length-1]);
    }

    private static int getMin(int cost[]) {
        int length=cost.length;
        int min=Integer.MAX_VALUE;
        int index=0;
        while(index<length) {
            min=Math.min(min,cost[index++]);
        }
        return min;
    }

    private static int getMinExcept(int cost[],int colorIndex) {
        int length=cost.length;
        int min=Integer.MAX_VALUE;
        int index=0;
        while(index<colorIndex) {

            min=Math.min(min,cost[index++]);
        }
        index++;
        while(index<length) {
            min=Math.min(min,cost[index++]);
        }
        return min;
    }
}
