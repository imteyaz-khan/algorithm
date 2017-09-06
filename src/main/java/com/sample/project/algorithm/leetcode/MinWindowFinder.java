package com.sample.project.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imteyaz.khan on 06/09/17.
 */
public class MinWindowFinder {


    public String minWindow(String s,String t) {
        String min="";
        if(s.length()<t.length()||s.length()==0||t.length()==0) return min;
        int counter[]=new int[256];
        for(char c:t.toCharArray()) counter[c]++;

        int start=0,end=0,size=0;
        while(end<s.length()) {
            if(counter[s.charAt(end++)]-- > 0) {
                size++;
            }
            while(size==t.length()) {
                if(min.equals("")||min.length()>(end-start)) min=s.substring(start,end);
                if(counter[s.charAt(start++)]++ >=0) {
                    size--;
                }
            }
        }
        return min;
    }
    public static void main(String[] args) {
        String source="MADOBECDODEBANC";
        String target="ABC";
        MinWindowFinder finder=new MinWindowFinder();
        System.out.println(finder.minWindow(source,target));
    }
}
