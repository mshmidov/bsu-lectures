package org.exadel.bsu.tasks.second.collections;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author skrauchenia
 */
public class MaxVariationTest {

    private MaxVariationTask task;

    @BeforeMethod
    public void init() {
        task = new MaxVariationTask();
    }

    @DataProvider(name = "max-variation-data")
    private Object[][] data() {
        return new Object[][]{
                new Integer[] {19, 21},
                new Integer[] {15, 30},
                new Integer[] {0, 0},
                new Integer[] {-1, null},
                new Integer[] {null, null}
        };
    }

    @Test(dataProvider = "max-variation-data")
    public void testOrdinary(Integer number, Integer expected) {
        int maxVariation = task.execute(number);
        assert maxVariation == expected : "Result incorrect";
    }
}
