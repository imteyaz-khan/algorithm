package com.sample.project.algorithm.bitwise;

/**
 * Created by imteyaz.khan on 19/07/17.
 */
public class OppositeSigns {
    public static boolean isOpposite(int number1,int number2) {
        return ((number1 ^ number2) <0);
    }
}
