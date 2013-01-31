package org.exadel.bsu.lectures.second.collections;

import java.util.Arrays;

/**
 * @author skrauchenia
 */
public class ArraysExample {

    public static void copyOfRange() {
        int[] nums = Arrays.copyOfRange(new int[]{1, 2, 3, 4, 5}, 3, 10);
        System.out.println(Arrays.toString(nums)); // [4, 5, 0, 0, 0, 0, 0]
    }

    public static void copyOf() {
        int[] nums = Arrays.copyOf(new int[]{1, 2, 3, 4, 5}, 8);
        System.out.println(Arrays.toString(nums)); // [1, 2, 3, 4, 5, 0, 0, 0]
    }

    public static void main(String[] args) {
        copyOf();
        copyOfRange();
    }
}
