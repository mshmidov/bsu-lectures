package org.exadel.bsu.tasks.second.collections;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * @author skrauchenia
 */
public class MostPopularWordsTest {

    private MostPopularWordsTask task;

    @BeforeMethod
    public void init() {
        task = new MostPopularWordsTask();
    }

    @DataProvider(name = "data")
    private Object[][] data() {
        return new Object[][]{
                new Object[] {"war_and_peace.txt", new ArrayList<Map.Entry<String, Integer>>() {{
                    add(new AbstractMap.SimpleEntry<>("и", 14516));
                    add(new AbstractMap.SimpleEntry<>("в", 6950));
                    add(new AbstractMap.SimpleEntry<>("не", 5893));
                    add(new AbstractMap.SimpleEntry<>("он", 5261));
                    add(new AbstractMap.SimpleEntry<>("что", 5068));
                    add(new AbstractMap.SimpleEntry<>("на", 4156));
                    add(new AbstractMap.SimpleEntry<>("с", 3913));
                    add(new AbstractMap.SimpleEntry<>("как", 2935));
                    add(new AbstractMap.SimpleEntry<>("его", 2685));
                    add(new AbstractMap.SimpleEntry<>("к", 2226));
                    add(new AbstractMap.SimpleEntry<>("я", 2200));
                    add(new AbstractMap.SimpleEntry<>("но", 2024));
                    add(new AbstractMap.SimpleEntry<>("все", 1886));
                    add(new AbstractMap.SimpleEntry<>("это", 1842));
                    add(new AbstractMap.SimpleEntry<>("она", 1764));
                    add(new AbstractMap.SimpleEntry<>("было", 1634));
                    add(new AbstractMap.SimpleEntry<>("так", 1455));
                    add(new AbstractMap.SimpleEntry<>("был", 1295));
                    add(new AbstractMap.SimpleEntry<>("а", 1291));
                    add(new AbstractMap.SimpleEntry<>("князь", 1289));
                }}},

                new Object[] {"empty_book.txt", new ArrayList<Map.Entry<String, Integer>>()},

                new Object[] {"one_word.txt", new ArrayList<Map.Entry<String, Integer>>() {{
                    add(new AbstractMap.SimpleEntry<>("hello", 2));
                }}}

        };
    }

    @Test(dataProvider = "data")
    public void testOrdinary(String bookFileName, List<Map.Entry<String, Integer>> expected) {
        String text = TaskDataUtil.bookText(bookFileName);
        List<Map.Entry<String, Integer>> words = task.execute(text);
        assertEquals(words, expected);
    }
}
