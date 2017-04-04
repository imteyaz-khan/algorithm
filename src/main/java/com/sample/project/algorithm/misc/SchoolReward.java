package com.sample.project.algorithm.misc;

/**
 * Created by imteyaz.khan on 31/03/17.
 */
public class SchoolReward {

    public static boolean shouldRewardStudent(String attendances) {
        int absentCount=0;
        int consecutiveLate=0;

        for(int index=0;index<attendances.length();index++) {
            char attendance=attendances.charAt(index);
            if(isOnTime(attendance)) {
                consecutiveLate=0;
                continue;
            }
            if(isLate(attendance)) {
                if(consecutiveLate>2) {
                    return false;
                }
                consecutiveLate++;
            } else {
                if(absentCount>1 || consecutiveLate>1) {
                    return false;
                }
                absentCount++;
            }
        }
        return true;
    }

    private static boolean isOnTime(char attendance) {
        return attendance=='O';
    }

    private static boolean isLate(char attendance) {
        return attendance=='L';
    }

    private static boolean isAbsent(char attendance) {
        return attendance=='A';
    }

    public static void main(String args[]) {
        System.out.println(shouldRewardStudent("OLLOAOLLO"));
    }
}
