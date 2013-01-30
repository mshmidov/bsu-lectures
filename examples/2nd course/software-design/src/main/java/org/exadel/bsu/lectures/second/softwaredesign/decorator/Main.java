package org.exadel.bsu.lectures.second.softwaredesign.decorator;

/**
 * @author mshmidov
 */
public final class Main {

    public static void main(String[] args) {

        final A a = new AnotherADecorator(new OneADecorator(new AImpl()));

        System.out.println(a.getName());
    }

}
