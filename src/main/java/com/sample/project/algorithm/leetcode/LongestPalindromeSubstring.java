package com.sample.project.algorithm.leetcode;

/**
 * Created by imteyaz.khan on 07/08/17.
 */
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if(s==null) {
            return null;
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++) {
            for(int j=s.length();j>i;j--) {
                if((j-i)<(end-start)) break;
                if(isPalindrome(s.substring(i,j))) {
                    start=i;
                    end=j;
                    break;
                }
            }
        }
        System.out.println(start+":"+end);
        return s.substring(start,end);
    }

    private boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        while(end>=start) {
            if(s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            end--;
            start++;
        }
        return true;
    }

    public String longestPalindromeCenter(String str) {
        int start=0;
        int end=0;
        for(int i=0;i<str.length();i++) {
            int len1=expandAroundCenter(str, i, i);
            int len2=expandAroundCenter(str, i, i + 1);
            int len=Math.max(len1,len2);
            if(len>(end-start)) {
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return str.substring(start,end+1);
    }

    private int expandAroundCenter(String str,int left,int right) {
        while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }



    public static void main(String[] args) {
        LongestPalindromeSubstring lpss=new LongestPalindromeSubstring();
        System.out.println(lpss.longestPalindromeCenter("cmbbd"));
    }
}
