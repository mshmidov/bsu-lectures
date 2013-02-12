package org.exadel.bsu.tasks.second.collections;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author skrauchenia
 */
public class SortStudentsTest {

    private SortStudentsTask task;

    @BeforeMethod
    public void init() {
        task = new SortStudentsTask();
    }

    @DataProvider(name = "data")
    private Object[][] data() {
        return new Object[][]{
                new Object[] {new ArrayList<>(Arrays.asList(
                        new Student("Иван", "Дмитриев"),
                        new Student("Николай", "Абрамов"),
                        new Student("Алексей", "Абрамов"),
                        new Student("Екатерина", "Юстинова")
                )), new ArrayList<>(Arrays.asList(
                        new Student("Алексей", "Абрамов"),
                        new Student("Николай", "Абрамов"),
                        new Student("Иван", "Дмитриев"),
                        new Student("Екатерина", "Юстинова")
                ))},

                new Object[] {Collections.emptyList(), Collections.emptyList()}
        };
    }

    @Test(dataProvider = "data")
    public void testOrdinary(List<Student> unsorted, List<Student> expectedSorted) {
        task.execute(unsorted);
        assertEquals(unsorted, expectedSorted, "Incorrect sorting");
    }
}
