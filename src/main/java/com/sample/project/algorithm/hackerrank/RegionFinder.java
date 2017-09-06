package com.sample.project.algorithm.hackerrank;

import javafx.geometry.Pos;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by imteyaz.khan on 30/08/17.
 */
public class RegionFinder {
    static int maxRegion(int cells[][]) {
        if(cells==null||cells[0].length==0) {
            return 0;
        }
        Set<Position> positionsToVisit=new HashSet<>();
        Set<Position> visitedPositions=new HashSet<>();
        for(int row=0;row<cells.length;row++) {
            for(int col=0;col<cells[0].length;col++) {
               if(cells[row][col]==1) {
                   positionsToVisit.add(new Position(row,col));
               }
            }
        }
        int max=0;
        for(Position position:positionsToVisit) {
            if(!visitedPositions.contains(position))  {
                int regionLength=getRegionLength(cells,position.row,position.col,visitedPositions);
                max=Math.max(regionLength,max);
            }
        }
        return max;
    }

    static int getRegionLength(int cells[][],int row,int col,Set<Position> visitedPositions) {
        if(row<0||row>cells.length-1||col<0||col>cells[0].length-1
                ||!valueOfCell(cells,row,col)||visitedPositions.contains(new Position(row,col))) {
            return 0;
        }

        if(valueOfCell(cells, row-1, col-1)||valueOfCell(cells, row-1, col)||valueOfCell(cells, row-1, col+1)||valueOfCell(cells, row, col-1)
                ||valueOfCell(cells, row, col+1)||valueOfCell(cells, row+1, col-1)||valueOfCell(cells, row+1, col)
                ||valueOfCell(cells, row+1, col+1)) {
            visitedPositions.add(new Position(row,col));
            int value=1;
            value=value+getRegionLength(cells, row, col+1, visitedPositions);
            value=value+getRegionLength(cells, row, col-1, visitedPositions);
            value=value+getRegionLength(cells, row+1, col-1, visitedPositions);
            value=value+getRegionLength(cells, row+1, col, visitedPositions);
            value=value+getRegionLength(cells, row+1, col+1, visitedPositions);
            value=value+getRegionLength(cells, row-1, col+1, visitedPositions);
            value=value+getRegionLength(cells, row-1, col-1, visitedPositions);
            value=value+getRegionLength(cells, row-1, col, visitedPositions);
            return value;
        }
        return cells[row][col];
    }

    static boolean valueOfCell(int cells[][],int row,int col) {
        return !(row<0||row>cells.length-1||col<0||col>cells[0].length-1) && cells[row][col] == 1;
    }

    static class Position {
        int row,col;
        public Position(int row,int col) {
            this.row=row;
            this.col=col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (col != position.col) return false;
            if (row != position.row) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int cells[][]=new int[n][m];
//        for(int index=0;index<n;index++) {
//            String s=in.next();
//            String numbers[]=s.split(s);
//            for(int i=0;i<numbers.length;i++) {
//                cells[index][i]=Integer.parseInt(numbers[i]);
//            }
//        }
//        int cells[][]={
//                {1,1,0,},
//                {0,1,1,0},
//                {0,0,1,0},
//                {1,0,0,0}};
        int cells[][]={
                {1,1,0,0,0},
                {0,1,1,0,0},
                {0,0,1,0,1},
                {1,0,0,0,1},
                {0,1,0,1,1}
        };
        System.out.println(maxRegion(cells));
    }
}
