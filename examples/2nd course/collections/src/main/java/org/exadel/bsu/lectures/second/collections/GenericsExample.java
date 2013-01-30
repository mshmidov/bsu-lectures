package org.exadel.bsu.lectures.second.collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author skrauchenia
 */
public class GenericsExample {

    private static void dangerousWithoutGenerics() {
        Collection phones = new ArrayList();
        phones.add("2354234");
        phones.add(2351122);
        for (Object element : phones) {
            String phoneNumber = (String) element;
        }
    }

    private static void safetyWithoutGenerics() {
        Collection phones = new ArrayList();
        phones.add("2354234");
        phones.add(2351122);
        for (Object element : phones) {
            if (element instanceof String) {
                String phoneNumber = (String) element;
            }
        }
    }

    private static void happinessWithGenerics() {
        Collection<String> phones = new ArrayList<>();
        phones.add("2354234");
//        phones.add(2351122); // compilation error
    }

    public static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static void pairUsage() {
        Pair<Integer, String> jan = new Pair<>(1, "January");
//        Pair<Integer, String> foo = new Pair<>("Second", "February"); // error

    }

    public static void main(String[] args) {

    }
}
