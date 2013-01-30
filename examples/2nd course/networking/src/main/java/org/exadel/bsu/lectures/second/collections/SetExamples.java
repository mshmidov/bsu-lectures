package org.exadel.bsu.lectures.second.collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author skrauchenia
 */
public class SetExamples {

    private static void treeSetExample() {
        Set<Customer> customers = new TreeSet<>();
        customers.add(new Customer("General Electric"));
        customers.add(new Customer("Disney Land"));
        customers.add(new Customer("BBC"));

        // [BBC, Disney Land, General Electric]
        System.out.println(customers);
    }
}
