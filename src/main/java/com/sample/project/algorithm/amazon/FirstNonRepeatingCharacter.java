package com.sample.project.algorithm.amazon;

/**
 * Created by imteyaz.khan on 08/07/17.
 */
public class FirstNonRepeatingCharacter {
    public static final int NOT_PRESENT=-1;
    public static char firstNonRepeatingCharacter(String str) {
        if(str==null||str.trim().length()==0) {
            throw new RuntimeException("Not present");
        }
        int counts[]=new int[26];
        int firstNonRepeatingCharacter=NOT_PRESENT;
        for(int index=0;index<str.length();index++) {
            int charCode=str.charAt(index)-97;
            counts[charCode]++;
            if(firstNonRepeatingCharacter==NOT_PRESENT && counts[charCode]==1) {
                firstNonRepeatingCharacter=charCode;
            } else if(charCode==firstNonRepeatingCharacter && counts[charCode]>1) {
                firstNonRepeatingCharacter=NOT_PRESENT;
            }
        }
        if(firstNonRepeatingCharacter==NOT_PRESENT) {
            throw new RuntimeException("Not present");
        }
        return (char)(97+firstNonRepeatingCharacter);
    }

    public static void main(String args[]) {
        System.out.println(firstNonRepeatingCharacter("aabbabeffgh"));
    }

}
