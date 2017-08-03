package com.sample.project.algorithm.bitwise;

/**
 * Created by imteyaz.khan on 19/07/17.
 */
public class SetBitCount {

    public static int findTheOnlyBitPosition(int number) {
        if(!isPowerofTwo(number)) {
            return -1;
        }
        int count=0;
        while(number>0) {
            count++;
            number=number>>1;
        }
        return count;
    }


    public static boolean isPowerofTwo(int number) {
        return number!=0 && ((number & (number-1))==0);
    }

    public static int xor(int number1,int number2) {
        return number1 ^ number2;
    }
    public static int shift(int number,int by,boolean left) {
        return left?number<<by:number>>by;
    }
    public static void main(String[] args) {
        int number=29;
        int set1=shift(number,1,false) & ((1<<1)-1);
        int set2=shift(number,3,false) & ((1<<1)-1);
        System.out.println(set1  ^ set2);
        System.out.println(shift(number,1,false));
    }
}
