package com.sample.project.algorithm.dynamic;

import java.util.List;

/**
 * Created by imteyaz.khan on 11/02/17.
 * This is still work in progress. So don't consider this as complete solution
 */
public class Balanced01Matrix {


    public static int[][] getPossibleBalancedArrayUsingDP(int arraySizeInEven) {
        int col1FillCount[]=new int[arraySizeInEven];
        int row1FillCount[]=new int[arraySizeInEven];


        int balanced01[][]=new int[arraySizeInEven][arraySizeInEven];

        for(int index=0;index<arraySizeInEven;index++) {
            col1FillCount[index]=0;
            row1FillCount[index]=0;
        }

        for(int i=0;i<arraySizeInEven;i++) {
            for(int j=0;j<arraySizeInEven;j++) {
                if(col1FillCount[j]<arraySizeInEven/2 && row1FillCount[i]<arraySizeInEven/2) {
                    balanced01[i][j]=1;
                    row1FillCount[i]=row1FillCount[i]+1;
                    col1FillCount[j]=col1FillCount[j]+1;
                } else {
                    balanced01[i][j]=0;
                }
            }
        }
        return balanced01;
    }

//    public static int[][] getPossibleBalancedArrayUsingDP(int arraySizeInEven,int initial,int positionPolicy) {
//
//        int col1FillCount[]=new int[arraySizeInEven];
//        int row1FillCount[]=new int[arraySizeInEven];
//        boolean indicator=true;
//        int positionCounter;
//        int value=initial;
//        int balanced01[][]=new int[arraySizeInEven][arraySizeInEven];
//
//        for(int index=0;index<arraySizeInEven;index++) {
//            col1FillCount[index]=-1;
//            row1FillCount[index]=-1;
//        }
//
//        for(int i=0;i<arraySizeInEven;i++) {
//            positionCounter=positionPolicy;
//            for(int j=0;j<arraySizeInEven;j++) {
//                if(col1FillCount[j]<arraySizeInEven/2 && row1FillCount[i]<arraySizeInEven/2) {
//                    if(positionCounter==0) {
//                        indicator=!indicator;
//                        value=flipZeroOne(indicator,initial);
//                        positionCounter=positionPolicy-1;
//                    } else {
//                        positionCounter--;
//                    }
//                    balanced01[i][j]=value;
//                    if(value==1) {
//                        col1FillCount[j]=col1FillCount[j]+1;
//                        row1FillCount[i]=row1FillCount[i]+1;
//                    }
//                } else {
//                    balanced01[i][j]=0;
//                }
//            }
//        }
//        return balanced01;
//    }

    public static int flipZeroOne(boolean indicator,int initial) {
        if(indicator) {
            return initial;
        } else {
            return getSecondary(initial);
        }
    }

    public static int getSecondary(int initial) {
        return initial==1?0:1;
    }

}
