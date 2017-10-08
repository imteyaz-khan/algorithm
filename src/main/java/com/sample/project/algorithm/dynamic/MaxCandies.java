package com.sample.project.algorithm.dynamic;

/**
 * Created by imteyaz.khan on 08/07/17.
 */
public class MaxCandies {

    public static int getMaxCandies(int cells[][],int row,int col) {
        if(cells==null||row<0||col<0) {
            return -1;
        }
        if(row>=cells.length || col>=cells[0].length) {
            return 0;
        }
        return cells[row][col]+Math.max(getMaxCandies(cells, row+1, col),getMaxCandies(cells, row, col+1));
    }

    public static int max(int cells[][]) {
        if(cells==null||cells.length<0||cells[0].length<0) {
            return -1;
        }
        int count=0;
        boolean computed[][]=new boolean[cells.length][cells[0].length];
        int numOfRow=cells.length;
        int noOfCol=cells[0].length;
        for(int i=0;i<numOfRow;i++) {
            for(int j=0;j<noOfCol;j++) {
                int value=cells[i][j];
                count++;
                if(i==0 && j==0) {
                    continue;
                } else if(i==0) {
                    value=value+cells[0][j-1];
                } else if(j==0) {
                    value=value+cells[i-1][0];
                } else {
                    value=value+Math.max(cells[i][j-1],cells[i-1][j]);
                }
                cells[i][j]=value;
            }
        }
        System.out.println("count:"+count);
        return cells[numOfRow-1][noOfCol-1];
    }

    public static void main(String args[]) {
        //int cells[][]={{2,4,3},{7,3,8},{10,2,10},{7,3,8},{27,100,100}};
        int cells[][]={{2,4,3},{7,3,8},{10,2,10}};
        System.out.println(getMaxCandies(cells,0,0));
        System.out.println(max(cells));
    }
}
