package com.sample.project.algorithm.leetcode;

/**
 * Created by imteyaz.khan on 06/08/17.
 */
public class MaxNonRepeatingSubString {
    private String s;

    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.trim().length()==0)  {
            return 0;
        }

        int max=1;
        int runningMax=1;
        int visitedPositions[]=new int[256];

        for(int index=0;index<256;index++) {
            visitedPositions[index]=-1;
        }

        visitedPositions[s.charAt(0)]=0;
        for(int index=1;index<s.length();index++) {
            int character=s.charAt(index);
            int visitedPosition=visitedPositions[character];
            if(visitedPosition==-1 || (index-runningMax> visitedPosition)) {
                runningMax++;
            } else {
                if(runningMax>max) {
                    max=runningMax;
                }
                runningMax=index-visitedPosition;
            }
            visitedPositions[character]=index;
        }
        if(runningMax>max) {
            max=runningMax;
        }
        return max;
    }

    public static void main(String[] args) {
        String str="abba";
        MaxNonRepeatingSubString maxNonRepeatingSubString=new MaxNonRepeatingSubString();
        System.out.println(maxNonRepeatingSubString.lengthOfLongestSubstring(str));
    }
}
