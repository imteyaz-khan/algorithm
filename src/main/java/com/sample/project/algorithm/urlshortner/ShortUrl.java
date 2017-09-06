package com.sample.project.algorithm.urlshortner;


import java.util.Stack;

/**
 * Created by imteyaz.khan on 11/08/17.
 */
public class ShortUrl {
    private static final String CHAR_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = CHAR_MAP.length();

    public static String encode(int id) {
        Stack<Character> characterStack=new Stack<>();

        while(id>0) {
            characterStack.push(CHAR_MAP.charAt(id % BASE));
            id=id/BASE;
        }
        StringBuilder stringBuilder=new StringBuilder();
        while(!characterStack.isEmpty()) {
            stringBuilder.append(characterStack.pop());
        }
        return stringBuilder.toString();
    }

    public static int decode(String str) {
        int number=0;
        for(int index=0;index<str.length();index++) {
            number=number*BASE+CHAR_MAP.indexOf(str.charAt(index));
        }
        return number;
    }

//    private static String encode(int id) {
//
//        StringBuilder sb = new StringBuilder();
//
//        while(id > 0) {
//            sb.append(CHAR_MAP.charAt(id%BASE));
//            id = id / BASE;
//        }
//        return sb.reverse().toString();
//    }
//
//
//    private static int decode(String shortUrl) {
//        int no = 0;
//        for(char c : shortUrl.toCharArray()) {
//            no = no * BASE + CHAR_MAP.indexOf(c);
//        }
//        return no;
//    }

//    public static String encode(int num) {
//        StringBuilder str = new StringBuilder();
//        while (num > 0) {
//            str.insert(0, CHAR_MAP.charAt(num % BASE));
//            num = num / BASE;
//        }
//        return str.toString();
//    }
//
//    public static int decode(String str) {
//        int num = 0;
//        for (int i = 0; i < str.length(); i++) {
//            num = num * BASE + CHAR_MAP.indexOf(str.charAt(i));
//        }
//        return num;
//    }

    public static void main(String[] args) {
        int id=decode("pgK8p");
        System.out.println(id);
        System.out.println(encode(id));
    }
}
