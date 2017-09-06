package com.sample.project.algorithm.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imteyaz.khan on 19/08/17.
 */
public class CardWinGame {
    private static final Map<Character,Integer> hierarchy =new HashMap(){{
        put('2',1);
        put('3',2);
        put('4',3);
        put('5',4);
        put('6',5);
        put('7',6);
        put('8',7);
        put('9',8);
        put('T',9);
        put('J',10);
        put('Q',11);
        put('K',12);
        put('A',13);
    }};
    public int solution(String A, String B) {
        validate(A);
        validate(B);
        int alecTurns=0;
        for(int index=0;index<A.length();index++) {
            if(hierarchy.get(A.charAt(index))>hierarchy.get(B.charAt(index))) {
                alecTurns++;
            }
        }
        return alecTurns;
    }

    private void validate(String str) {
        if(str==null||str.trim().length()==0) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public static void main(String[] args) {
        CardWinGame cardWinGame=new CardWinGame();
        System.out.println(cardWinGame.solution("A586QK","JJ653K"));
        System.out.println(cardWinGame.solution("23A84Q","K2Q25J"));
    }
}
