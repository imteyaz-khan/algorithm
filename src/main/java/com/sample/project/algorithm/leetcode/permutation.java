package com.sample.project.algorithm.leetcode;

/**
 * Created by imteyaz.khan on 01/08/17.
 */
public class Permutation {
    private static int count=0;
    public void permutation(String prefix,String str) {
        //System.out.println(str);

        if(str.length()==0) {
            System.out.println(prefix);
        } else {

            for(int index=0;index<str.length();index++) {
                count++;
                permutation(prefix+str.charAt(index), str.substring(0,index)+str.substring(index+1,str.length()));
            }
        }
    }
    public static void main(String[] args) {
        String str="aaaa";
        Permutation test=new Permutation();
        test.permutation("", str);
        System.out.println(count);
    }
}
