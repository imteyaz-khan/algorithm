package com.sample.project.algorithm.geeksforgeeks;

/**
 * Created by imteyaz.khan on 24/08/17.
 */
public class NPotGold {
    static int count=0;

    public int getMax(int pots[]) {
        if(pots.length==0) {
            return -1;
        }
        if(pots.length==1) {
            return pots[0];
        }
        int total=0;
        for(int value:pots) {
            total=total+value;
        }
        Integer memo[][]=new Integer[pots.length][pots.length];
        return getMaxOfA(pots,0,pots.length-1,memo);
    }

    private int getMaxOfA(int[] pots, int start, int end,Integer memo[][]) {
        count++;
        if(end-start==1) {
            return Math.max(pots[start],pots[end]);
        }
        if(memo[start][end]!=null) {

            return memo[start][end];
        }
        int a=pots[start]+Math.min(getMaxOfA(pots, start + 2, end,memo), getMaxOfA(pots,start+1,end-1,memo));
        int b=pots[end]+Math.min(getMaxOfA(pots, start, end-2,memo), getMaxOfA(pots,start+1,end-1,memo));
        memo[start][end]=Math.max(a,b);

        return memo[start][end];
    }

    public static void main(String[] args) {
        //int[] B = { 1,2,3,4};
        //int[] B = { 12, 32, 4, 23, 6, 42, 16, 3, 85, 23, 4, 7, 3, 5, 45, 34, 2, 1,27,1,100,3 };
        int[] B={6, 9,1,2,16,8};
        NPotGold nPotGold=new NPotGold();
        System.out.println("Method DP: " + nPotGold.getMax(B));
        System.out.println("Method from internet: "+getMaxGold(B));
        System.out.println(count);
    }


    private static int getMaxGold(int[] goldPots)
    {
        Integer[][]memo=new Integer[goldPots.length][goldPots.length];
        return getMaxGold(goldPots, 0, goldPots.length - 1,memo);
    }

    private static int getMaxGold(int[] goldPots, int startIndex, int endIndex,Integer[][]memo)
    {
        if (startIndex > endIndex)
            return 0;
        if(memo[startIndex][endIndex]!=null)
            return memo[startIndex][endIndex];
        int coinsIfStart = goldPots[startIndex]
                + Math.min(getMaxGold(goldPots, startIndex + 2, endIndex,memo),
                getMaxGold(goldPots, startIndex + 1, endIndex - 1,memo));
        int coinsIfEnd = goldPots[endIndex]
                + Math.min(getMaxGold(goldPots, startIndex, endIndex - 2,memo),
                getMaxGold(goldPots, startIndex + 1, endIndex - 1,memo));
        memo[startIndex][endIndex]=Math.max(coinsIfStart, coinsIfEnd);
        return memo[startIndex][endIndex];
    }
}
