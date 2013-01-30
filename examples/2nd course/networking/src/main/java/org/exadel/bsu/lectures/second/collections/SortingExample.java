package org.exadel.bsu.lectures.second.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author skrauchenia
 */
public class SortingExample {

    private static void naturalIntOrder() {
        List<Integer> primes = new ArrayList<>();
        Collections.addAll(primes, 11, 7, 5, 2, 3, 13);
        System.out.println(primes); // [11, 7, 5, 2, 3, 13]
        Collections.sort(primes);
        System.out.println(primes); // [2, 3, 5, 7, 11, 13]
    }

    static class DescIntComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    private static void descIntSortOrder() {
        List<Integer> primes = new ArrayList<>();
        Collections.addAll(primes, 11, 7, 5, 2, 3, 13);
        System.out.println(primes); // [11, 7, 5, 2, 3, 13]
        Collections.sort(primes, new DescIntComparator());
        System.out.println(primes); // [13, 11, 7, 5, 3, 2]
    }

    private static void customerOrder() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("General Electric"));
        customers.add(new Customer("Disney Land"));
        customers.add(new Customer("BBC"));
        Collections.sort(customers);

        // [BBC, Disney Land, General Electric]
        System.out.println(customers);
    }
}
