package com.sample.project.algorithm.dynamic;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
/**
 * Created by imteyaz.khan on 12/02/17.
 */
public class HouseColoringTest {

    @Test
    public  void shouldGetMinimumColoringCostIfOnlyOneStreet() {
        int cost[][]={{2,4,3}};
        assertEquals(2, HouseColoring.minCostWithThreeColor(cost));
    }

    @Test
    public  void shouldGetMinimumColoringCostWith3Color() {
        int cost[][]={{2,4,3},{7,3,8},{10,2,10},{7,3,8},{27,100,100}};
        assertEquals(45,HouseColoring.minCostWithThreeColor(cost));
    }

    @Test
    public  void shouldGetMinimumColoringCostWithNColor() {
        int cost[][]={{2,4,3,10},{7,3,8,5},{10,2,10,11},{7,3,8,2},{27,100,100,5}};
        assertEquals(21,HouseColoring.minCostWithNColor(cost));
    }
}
