package org.exadel.bsu.lectures.second.softwaredesign.decorator;

public class AnotherADecorator extends ADecorator {

    public AnotherADecorator(A decoratedObject) {
        super(decoratedObject);
    }

    @Override
    public String getName() {
        return super.getName() + " decorated with Decorator 2";
    }
}
