package com.sample.project.algorithm.misc;

import com.sample.project.datastructure.Stack;

/**
 * Created by imteyaz.khan on 21/03/17.
 */
public class NumberConverter {

    public static String getBinary(int number) {
        if(number==0) {
            return "0";
        }
        Stack<Character> stack=new Stack<>();
        while(number>=1) {
            if(number%2==1) {
                stack.push('1');
            } else {
                stack.push('0');
            }
            number=number/2;
        }

        StringBuilder binaryStringBuilder=new StringBuilder();
        while (!stack.isEmpty()) {
            binaryStringBuilder.append(stack.pop());
        }
        return binaryStringBuilder.toString();
    }

    public static int getDecimalFromBinary(String binary) {
        if(binary==null || binary.isEmpty()) {
            return -1;
        }
        int number=0;
        int power=0;
        for(int index=binary.length()-1;index>=0;index--) {
            number=number+Integer.parseInt(String.valueOf(binary.charAt(index)))*(int)Math.pow(2,power);
            power++;
        }
        return number;
    }

    public static void main(String args[]) {
        System.out.println(getBinary(129));
        System.out.println(getDecimalFromBinary(getBinary(129)));
    }
}
