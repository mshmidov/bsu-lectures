package org.exadel.bsu.lectures.second.softwaredesign.decorator;

/**
 * @author mshmidov
 */
public class ADecorator implements A {

    private final A decoratedObject;

    public ADecorator(A decoratedObject) {
        this.decoratedObject = decoratedObject;
    }

    @Override
    public String getName() {
        return decoratedObject.getName(); // делегирование метода
    }
}
