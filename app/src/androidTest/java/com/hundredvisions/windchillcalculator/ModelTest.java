package com.hundredvisions.windchillcalculator;

import android.test.InstrumentationTestCase;

/**
 * Created by winikkc on 5/3/2016.
 */
public class ModelTest extends InstrumentationTestCase{
    public void test() throws Exception {
        final int expected = 1;
        final int reality = 1;
        assertEquals(expected, reality);
    }
    public void testIsInRangeForTrue() throws Exception {
        final boolean expected = true;
        final int data = 50;
        final int lower = 0;
        final int upper = 100;
        final boolean reality = Model.isInRange(data,lower,upper);
        assertEquals(expected,reality);
    }
    public void testIsInRangeForFalse() throws Exception {
        final boolean expected = false;
        final int data = 150;
        final int lower = 0;
        final int upper = 100;
        final boolean reality = Model.isInRange(data, lower, upper);
        assertEquals(expected, reality);
    }
}
