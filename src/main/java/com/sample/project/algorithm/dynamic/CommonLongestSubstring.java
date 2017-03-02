package com.sample.project.algorithm.dynamic;

/**
 * Created by imteyaz.khan on 28/02/17.
 */
public class CommonLongestSubstring {
    public int getCommonLongestSubString(String str1,String str2) {
        if(str1==null || str1.trim().length()==0 || str2==null || str2.trim().length()==0)
            return  0;

        int result=0;
        int lcs[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=1;i<=str1.length();i++) {
            for(int j=1;j<=str2.length();j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    lcs[i][j]=lcs[i-1][j-1]+1;
                    result=Math.max(result,lcs[i][j]);
                } else {
                    lcs[i][j]=0;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        CommonLongestSubstring lcs=new CommonLongestSubstring();
        System.out.println(lcs.getCommonLongestSubString("imteyaz","bctez"));
    }
}
