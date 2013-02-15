package org.exadel.bsu.tasks.second.collections;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author skrauchenia
 */
public class NurseryRhymeTest {

    private NurseryRhymeTask task;

    @BeforeMethod
    public void init() {
        task = new NurseryRhymeTask();
    }

    @DataProvider(name = "data")
    private Object[][] data() {
        return new Object[][]{
                new Object[] {new Integer[]{5}, 10, 5},
                new Object[] {new Integer[]{5, 4, 77, 32, 111, 0, 5, 23, 742, 11111, 99130}, 2, 5},
                new Object[] {new Integer[]{5, 4, 77, 32, 111, 0, 5, 23, 742, 11111, 99130}, 7, 111},
                new Object[] {new Integer[]{5, 6}, 10, 5},
                new Object[] {new Integer[]{5, 6, 7, 12, 5455}, 1, 5455}

        };
    }

    @DataProvider(name = "exceptional-data")
    private Object[][] exceptionalData() {
        return new Object[][]{
                new Object[] {null, 1},
                new Object[] {null, 0},
                new Object[] {new Integer[] {1,2,3}, 0},
                new Object[] {new Integer[]{}, 1},
                new Object[] {new Integer[]{}, 0}

        };
    }

    @Test(dataProvider = "data")
    public void testOrdinary(Integer[] numbers, int posForDelete, Integer expectedResult) {
        Integer last = task.execute(numbers, posForDelete);
        assertEquals(last, expectedResult);
    }

    @Test(dataProvider = "exceptional-data", expectedExceptions = IllegalArgumentException.class)
    public void testException(Integer[] numbers, int posForDelete) {
        task.execute(numbers, posForDelete);
    }
}
