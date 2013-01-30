package org.exadel.bsu.lectures.second.collections;

/**
 * @author skrauchenia
 */
class Customer implements Comparable<Customer> {
    int id;
    private String name;

    Customer(String name) {
        this.name = name;
    }

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.name);
    }

    public String toString() {
        return this.name;
    }
}
