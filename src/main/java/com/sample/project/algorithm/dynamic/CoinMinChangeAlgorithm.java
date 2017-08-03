package com.sample.project.algorithm.dynamic;

import com.sample.project.datastructure.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by imteyaz.khan on 13/02/17.
 */
public class CoinMinChangeAlgorithm {
    public static int getMinCoinChange(int amount,int coins[]) {
        Map<Integer,Integer>memorization=new HashMap<Integer,Integer>();
        int min= getMinCoinChange(amount, coins,memorization);
        System.out.println(memorization);
        return min;
    }

    private static int getMinCoinChange(int amount,int coins[],Map<Integer,Integer> memorization) {

        if(amount==0) {
            return 0;
        }

        if(memorization.containsKey(amount)) {
            return memorization.get(amount);
        }
        int min=Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) {
                continue;
            }
            int ways = getMinCoinChange(amount - coin, coins, memorization);
            if (ways < min) {
                min = ways;
            }
        }

        if(min!=Integer.MAX_VALUE) {
            min=min+1;
        }
        memorization.put(amount,min);
        return min;
    }





    public static void main(String args[]) {
        int coins[]={1,2,7};
        System.out.println(getMinCoinChange(1000,coins));
    }
}
