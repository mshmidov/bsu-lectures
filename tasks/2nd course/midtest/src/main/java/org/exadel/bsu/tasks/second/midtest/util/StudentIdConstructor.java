package org.exadel.bsu.tasks.second.midtest.util;

/**
 * @author skrauchenia
 */
public final class StudentIdConstructor {

    private StudentIdConstructor() {

    }

    public static String construct(String studentName, String clientAddress) {
        return String.format("%s@%s", studentName, clientAddress);
    }
}
