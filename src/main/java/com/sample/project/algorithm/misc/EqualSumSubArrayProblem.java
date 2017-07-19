package com.sample.project.algorithm.misc;

import java.util.*;

/**
 * Created by imteyaz.khan on 05/04/17.
 */
public class EqualSumSubArrayProblem {

    public boolean hasPartition(int numbers[]) {
        int sum = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int number : numbers) {
            sum = sum + number;
            addNumberToMap(map1, number);
        }
        partition(map1, map2, sum, 0);
        System.out.println(map1);
        System.out.println(map2);
        return sum(map1.values()) == sum(map2.values());
    }

    public void partition(Map<Integer, Integer> largerSumMap, Map<Integer, Integer> smallerSumMap, int sum1, int sum2) {
        if (sum1 == sum2) {
            return;
        }

        if (sum1 > sum2) {
            int diff = sum1 - sum2;
            int number = getNextHigherValue(largerSumMap, diff);
            if (number == 0) {
                return;
            } else {
                exchange(smallerSumMap, largerSumMap, number);
                partition(largerSumMap, smallerSumMap, sum1 - number, sum2 + number);
            }

        } else {
            int diff = sum2 - sum1;
            int number = getNextHigherValue(smallerSumMap, diff);
            if (number == 0) {
                return;
            } else {
                exchange(largerSumMap, smallerSumMap, number);
                partition(smallerSumMap, largerSumMap, sum1 + number, sum2 - number);
            }

        }
    }


    private int getNextHigherValue(Map<Integer, Integer> map, int number) {
        while (number > 0) {
            number--;
            if (map.get(number) != null && map.get(number) != 0) {
                break;
            }
        }
        return number;
    }

    private int getNextLowerValue(Map<Integer, Integer> map, int number) {
        int lowerValue = 0;
        while (number >= lowerValue) {
            lowerValue++;
            if (map.get(lowerValue) != null && map.get(number) != 0) {
                break;
            }
        }
        return lowerValue;
    }

    private void exchange(Map<Integer, Integer> map1, Map<Integer, Integer> map2, int number) {
        addNumberToMap(map1, number);
        removeNumberFromMap(map2, number);
    }

    private void doAdjustment(Map<Integer, Integer> map1, Map<Integer, Integer> map2, int number) {
        // exchange two nearest numbers compare to number with each othermap
    }

    private void addNumberToMap(Map<Integer, Integer> map, int number) {
        if (map.get(number) == null) {
            map.put(number, number);
        } else {
            map.put(number, map.get(number) + number);
        }
    }

    private void removeNumberFromMap(Map<Integer, Integer> map, int number) {
        if (map.get(number) - number == 0) {
            map.remove(number);
        } else {
            map.put(number, map.get(number) - number);
        }
    }

    private int sum(Collection<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        return sum;
    }
}
