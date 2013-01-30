package org.exadel.bsu.lectures.second.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author skrauchenia
 */
public class MapExamples {

    private static void hashMapExample() {
        Map<Object, Integer> month = new HashMap<>();
        month.put(new Object(), 0);
        month.put(new Object(), 1);
        month.put(new Object(), 2);
        System.out.println(month);
        // {java.lang.Object@be9340=0, java.lang.Object@1bbea67=2, java.lang.Object@1b56bda=1}
    }

    private static void treeMapExample() {
        Map<String, Integer> month = new TreeMap<>();
        month.put("Jan", 0);
        month.put("Feb", 1);
        month.put("March", 2);
        System.out.println(month); // {Feb=1, Jan=0, March=2}
    }

    public static void main(String[] args) {
        hashMapExample();
        treeMapExample();
    }
}
