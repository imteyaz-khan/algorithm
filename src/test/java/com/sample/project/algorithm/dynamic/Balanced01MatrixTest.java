package com.sample.project.algorithm.dynamic;

import org.junit.Test;

/**
 * Created by imteyaz.khan on 12/02/17.
 */
public class Balanced01MatrixTest {

    @Test
    public void shouldGetBalanced01Matrix() {
        int matrixSize=6;
        int[][] balanced01Matrix=Balanced01Matrix.getPossibleBalancedArrayUsingDP(matrixSize);
        for(int i=0;i<matrixSize;i++) {
            for(int j=0;j<matrixSize;j++) {
                System.out.print(balanced01Matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
