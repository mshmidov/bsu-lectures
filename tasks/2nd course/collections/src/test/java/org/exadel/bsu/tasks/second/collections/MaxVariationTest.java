package org.exadel.bsu.tasks.second.collections;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author skrauchenia
 */
public class MaxVariationTest {

    private MaxVariationTask task;

    @BeforeMethod
    public void init() {
        task = new MaxVariationTask();
    }

    @DataProvider(name = "data")
    private Object[][] data() {
        return new Object[][]{
                new Integer[] {19, 28},
                new Integer[] {15, 15},
                new Integer[] {0, 0},
                new Integer[] {null, null},
                new Integer[] {54722, 57706}
        };
    }

    @Test(dataProvider = "data")
    public void testOrdinary(Integer number, Integer expected) {
        Integer maxVariation = task.execute(number);
        assertEquals(maxVariation, expected, "Result incorrect");
    }
}
