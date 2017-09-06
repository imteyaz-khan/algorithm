package com.sample.project.algorithm.codility;

import java.util.*;

/**
 * Created by imteyaz.khan on 20/08/17.
 */
public class PhoneCallChangeCalculator {
    public static final int PER_MINUTE_CHARGE=150;
    public static final int PER_SECOND_CHARGE=3;

    int maxDuration=0;
    Set<String> maxDurationNumbers=new TreeSet<>();
    Map<String,Charge> mobileToCalculatedChange=new HashMap<>();

    public int solution(String S) {

        StringBuilder line=new StringBuilder();
        for(int index=0;index<S.length();index++) {
            char character=S.charAt(index);
            if(character != 10) {
                line.append(character);
            } else {
                calculateChanges(line);
                line.delete(0,line.length());
            }
        }

        if(line.toString().trim().length()>0) {
            calculateChanges(line);
        }
        String phoneNumber=maxDurationNumbers.iterator().next();
        mobileToCalculatedChange.get(phoneNumber).setCharge(0);

        int totalCharge=0;
        for(Map.Entry<String, Charge> entry:mobileToCalculatedChange.entrySet()) {
            totalCharge=totalCharge+entry.getValue().getCharge();
        }
        return totalCharge;
    }

    private void calculateChanges(StringBuilder line) {
        CallDetails callDetails=new CallDetails(line.toString().trim());
        Charge charge=mobileToCalculatedChange.get(callDetails.getPhoneNumber());
        if(charge==null) {
            charge=new Charge();
        }

        charge.setDuration(charge.getDuration()+callDetails.getActualDurationInSecond());
        charge.setCharge(charge.getCharge()+getCalculatedCharge(callDetails));
        if(charge.getDuration()>=maxDuration) {
            if(charge.getDuration()>maxDuration) {
                maxDurationNumbers.clear();
            }
            maxDuration=charge.getDuration();
            maxDurationNumbers.add(callDetails.getPhoneNumber());
        }
        mobileToCalculatedChange.put(callDetails.getPhoneNumber(),charge);
    }
    private int getCalculatedCharge(CallDetails callDetails) {
        int charge=callDetails.isDurationInMinute()?PER_MINUTE_CHARGE:PER_SECOND_CHARGE;
        return callDetails.getDuration()*charge;
    }


    private class CallDetails {
        String phoneNumber;
        int hour;
        int minute;
        int second;

        CallDetails(String callLog) {
            populate(callLog);
        }

        String getPhoneNumber() {
            return this.phoneNumber;
        }

        int getDuration() {
            if((hour*60+minute)>=5) {
                return second>0?hour*60+minute+1:hour*60+minute;
            }
            return minute*60+second;
        }

        int getActualDurationInSecond() {
            return hour*60*60+minute*60+second;
        }

        boolean isDurationInMinute() {
            return (hour*60+minute)>=5;
        }

        private void populate(String callLog) {
            String[] tokens=callLog.split(",");

            String[] durationTokens=tokens[0].split(":");
            this.hour=Integer.parseInt(durationTokens[0]);
            this.minute=Integer.parseInt(durationTokens[1]);
            this.second=Integer.parseInt(durationTokens[2]);

            this.phoneNumber=tokens[1];
        }
    }

    private class Charge {

        int duration;
        int charge;

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getCharge() {
            return charge;
        }

        public void setCharge(int charge) {
            this.charge = charge;
        }
    }

    public static void main(String[] args) {
        String s="00:01:07,400-234-090\n" +
                "00:05:01,701-080-080\n" +
                "00:05:00,400-234-090";
        PhoneCallChangeCalculator phoneCallChangeCalculator=new PhoneCallChangeCalculator();
        System.out.println(phoneCallChangeCalculator.solution(s));
    }
}
