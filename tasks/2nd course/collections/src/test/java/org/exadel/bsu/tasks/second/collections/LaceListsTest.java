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
public class LaceListsTest {

    private LaceListsTask task;

    @BeforeMethod
    public void init() {
        task = new LaceListsTask();
    }

    @DataProvider(name = "data")
    private Object[][] data() {
        return new Object[][]{
                new Object[] {asList('a'), asList('b'), asList('a', 'b')},
                new Object[] {asList('a', 'c'), asList('b', 'd'), asList('a', 'b', 'c', 'd')},
                new Object[] {asList('a', 'c', 'e', 'f'), asList('b', 'd'), asList('a', 'b', 'c', 'd', 'e', 'f')},
                new Object[] {asList('a', 'c'), asList('b', 'd', 'e', 'f'), asList('a', 'b', 'c', 'd', 'e', 'f')},
                new Object[] {emptyList(), emptyList(), emptyList()},
                new Object[] {asList('a'), emptyList(), asList('a')},
                new Object[] {emptyList(), asList('a'), asList('a')},
                new Object[] {null, asList('a'), asList('a')},
                new Object[] {asList('a'), null, asList('a')},
                new Object[] {null, null, emptyList()},

        };
    }

    @Test(dataProvider = "data")
    public void testOrdinary(List<Character> s1, List<Character> s2, List<Character> expected) {
        List<Character> result = task.execute(s1, s2);
        assertEquals(result, expected);
    }
}
