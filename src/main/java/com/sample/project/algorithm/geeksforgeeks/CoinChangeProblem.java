package com.sample.project.algorithm.geeksforgeeks;

/**
 * Created by imteyaz.khan on 28/08/17.
 */
public class CoinChangeProblem {
    public int getNumberOfWay(int coins[],int coinIndex,int amount) {
        if(amount==0) {
            return 1;
        }
        if(amount<0 || coinIndex==coins.length && amount >0) {
            return 0;
        }
        return getNumberOfWay(coins, coinIndex, amount-coins[coinIndex])+getNumberOfWay(coins, coinIndex+1, amount);
    }

    public int getNumberOfWayUsingDP(int coins[],int amount) {
        int solution[][]=new int[coins.length+1][amount+1];
        for(int index=0;index<=amount;index++) {
            solution[0][index]=0;
        }

        for(int index=0;index<=coins.length;index++) {
            solution[index][0]=1;
        }

        for(int i=1;i<=coins.length;i++) {
            for(int j=1;j<=amount;j++) {
                solution[i][j]=solution[i-1][j];
                if(j>=coins[i-1]) {
                    solution[i][j]=solution[i-1][j]+solution[i][j-coins[i-1]];
                }
            }
        }
        return solution[coins.length][amount];
    }

    public static void main(String args[]) {
        int coins[]={1,2,3};
        CoinChangeProblem coinChangeProblem=new CoinChangeProblem();
        System.out.println(coinChangeProblem.getNumberOfWay(coins,0,5));
        System.out.println(coinChangeProblem.getNumberOfWayUsingDP(coins,5));
    }
}
