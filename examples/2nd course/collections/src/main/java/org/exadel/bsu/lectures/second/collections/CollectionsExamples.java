package org.exadel.bsu.lectures.second.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author skrauchenia
 */
public class CollectionsExamples {

    private static void collectionsAddAll() {
        Set<Integer> nums = new HashSet<>();
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(1);

        Set<Integer> nums1 = new HashSet<>();
        Collections.addAll(nums1, 3, 4, 5, 1);
    }
}
