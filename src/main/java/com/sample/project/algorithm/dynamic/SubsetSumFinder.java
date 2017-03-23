package com.sample.project.algorithm.dynamic;

/**
 * Created by imteyaz.khan on 22/02/17.
 */
public class SubsetSumFinder {
    public boolean isSumPossible(int numbers[],int index,int sum) {
        if(sum==0) {
            return true;
        }
        if(numbers.length==index && sum!=0) {
            return false;
        }
        return isSumPossible(numbers, index + 1, sum - numbers[index]) || isSumPossible(numbers, index + 1, sum);
    }

    public boolean isSumPossibleUsingDP(int numbers[],int sum) {
        boolean subset[][]=new boolean[numbers.length+1][sum+1];
        for(int index=0;index<=numbers.length;index++) {
            subset[index][0]=true;
        }

        for(int i=1;i<=numbers.length;i++) {
            for(int j=1;j<=sum;j++) {
                subset[i][j]=subset[i-1][j];
                if(!subset[i][j] && j>=numbers[i-1]) {
                    subset[i][j]=subset[i-1][j-numbers[i-1]];
                }
            }
        }
        return subset[numbers.length][sum];
    }
    public static void main(String args[]) {
        int numbers[]={1,3,4,1};
        SubsetSumFinder subsetSumFinder=new SubsetSumFinder();
        System.out.println(subsetSumFinder.isSumPossibleUsingDP(numbers,10));
    }

}
