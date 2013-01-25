package org.exadel.bsu.lectures.second.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

/**
 * @author skrauchenia
 */
public class ListExamples {

    private static void changingItemsInSubList() {
        List<Integer> even = new ArrayList<>();
        Collections.addAll(even, 2, 4, 6, 8, 10, 12);
        List<Integer> lastTwo = even.subList(4, even.size());
        System.out.println(lastTwo); // [10, 12]
        lastTwo.add(1, 11);
        System.out.println(even); // [2, 4, 6, 8, 10, 11, 12]
        lastTwo.remove(2);
        System.out.println(even); // [2, 4, 6, 8, 10, 11]
        Collections.swap(lastTwo, 0, 1);
        System.out.println(even); // [2, 4, 6, 8, 11, 10]
    }

    private static void listIteratorUsage() {
        List<Integer> fibs = new ArrayList<>();
        Collections.addAll(fibs, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        ListIterator<Integer> iterator = fibs.listIterator(fibs.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    private static void linkedListUsage() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        queue.offer(0); // [1, 2, 3, 4, 0]
        queue.poll();   // [2, 3, 4, 0]

        Deque<Integer> stack = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        stack.pop(); // [2, 3, 4]
        stack.push(0); // [0, 2, 3, 4]
    }

    public static void main(String[] args) {
        linkedListUsage();
    }
}
