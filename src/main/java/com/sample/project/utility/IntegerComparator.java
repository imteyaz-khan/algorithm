package com.sample.project.utility;

import java.util.Comparator;

/**
 * Created by imteyaz.khan on 22/01/17.
 */
public class IntegerComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
