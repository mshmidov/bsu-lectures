package org.exadel.bsu.tasks.second.collections;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.testng.Assert.assertEquals;

/**
 * @author skrauchenia
 */
public class LongestIncreasingSubsequenceTest {

    private LongestIncreasingSubsequenceTask task;

    @BeforeMethod
    public void init() {
        task = new LongestIncreasingSubsequenceTask();
    }

    @DataProvider(name = "data")
    private Object[][] data() {
        return new Object[][]{
                new Object[] {asList(8, 1, 3, 2, 3, 9, 4, 8, 6), asList(1, 2, 3, 4, 6)},
                new Object[] {emptyList(), emptyList()},
                new Object[] {asList(6), asList(6)}

        };
    }

    @Test(dataProvider = "data")
    public void testOrdinary(List<Integer> seq, List<Integer> longestExpected) {
        List<Integer> longestSubseq = task.execute(seq);
        assertEquals(longestSubseq, longestExpected);
    }
}
