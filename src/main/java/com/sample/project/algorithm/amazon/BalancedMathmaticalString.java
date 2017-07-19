package com.sample.project.algorithm.amazon;

import com.sample.project.datastructure.Stack;

/**
 * Created by imteyaz.khan on 08/07/17.
 */
public class BalancedMathmaticalString {

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < str.length(); index++) {
            char charAt = str.charAt(index);
            if (isClosingBrace(charAt)) {
                Character popCharacter = stack.pop();
                if (!isPair(popCharacter, charAt)) {
                    return false;
                }
            } else {
                stack.push(charAt);
            }

        }
        return stack.isEmpty();
    }

    public static boolean isClosingBrace(char character) {
        return character == ')' || character == '}' || character == ']';
    }

    public static boolean isPair(char element1, char element2) {
        switch (element1) {
            case '(':
                return ')' == element2;
            case '{':
                return '}' == element2;
            case '[':
                return ']' == element2;
        }
        return false;
    }

    public static void main(String[] args) {
        String validMathString = "[()]{}{[()()]()}";
        String invalidMathString = "[(])";
        System.out.println(isBalanced(validMathString));
    }
}
