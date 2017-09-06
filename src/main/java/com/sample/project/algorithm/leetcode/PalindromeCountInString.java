package com.sample.project.algorithm.leetcode;

/**
 * Created by imteyaz.khan on 15/08/17.
 */
public class PalindromeCountInString {
    public int countSubstrings(String s) {
        int count=0;
        for(int step=1;step<=s.length();step++) {
            for(int index=0;index<s.length()-(step-1);index++) {
                if(isPalindrome(s,index,index+step-1)) {
                    count=count+1;
                }
            }
        }

        return count;
    }

    public boolean isPalindrome(String s,int start,int end) {
        while(start<=end) {
            if(s.charAt(start)!=s.charAt(end)) {
                return false;

            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeCountInString palindromeCountInString=new PalindromeCountInString();
        System.out.println(palindromeCountInString.countSubstrings("aabbaa"));
    }
}



