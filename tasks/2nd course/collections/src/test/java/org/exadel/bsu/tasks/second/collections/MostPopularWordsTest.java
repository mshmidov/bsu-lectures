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
                    add(new AbstractMap.SimpleEntry<>("и", 14484));
                    add(new AbstractMap.SimpleEntry<>("в", 6940));
                    add(new AbstractMap.SimpleEntry<>("не", 5886));
                    add(new AbstractMap.SimpleEntry<>("он", 5211));
                    add(new AbstractMap.SimpleEntry<>("что", 5023));
                    add(new AbstractMap.SimpleEntry<>("на", 4152));
                    add(new AbstractMap.SimpleEntry<>("с", 3907));
                    add(new AbstractMap.SimpleEntry<>("как", 2900));
                    add(new AbstractMap.SimpleEntry<>("его", 2675));
                    add(new AbstractMap.SimpleEntry<>("к", 2222));
                    add(new AbstractMap.SimpleEntry<>("я", 2163));
                    add(new AbstractMap.SimpleEntry<>("но", 2015));
                    add(new AbstractMap.SimpleEntry<>("все", 1868));
                    add(new AbstractMap.SimpleEntry<>("это", 1798));
                    add(new AbstractMap.SimpleEntry<>("она", 1742));
                    add(new AbstractMap.SimpleEntry<>("было", 1629));
                    add(new AbstractMap.SimpleEntry<>("так", 1431));
                    add(new AbstractMap.SimpleEntry<>("был", 1292));
                    add(new AbstractMap.SimpleEntry<>("князь", 1282));
                    add(new AbstractMap.SimpleEntry<>("а", 1271));
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
