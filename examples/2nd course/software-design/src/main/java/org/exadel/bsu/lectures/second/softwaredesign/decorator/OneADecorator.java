package org.exadel.bsu.lectures.second.softwaredesign.decorator;

public class OneADecorator extends ADecorator {

    public OneADecorator(A decoratedObject) {
        super(decoratedObject);
    }

    @Override
    public String getName() {
        return super.getName() + " decorated with Decorator 1";
    }
}
