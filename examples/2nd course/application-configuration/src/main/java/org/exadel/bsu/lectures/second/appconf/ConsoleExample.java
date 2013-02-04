package org.exadel.bsu.lectures.second.appconf;

/**
 * @author skrauchenia
 */
public class ConsoleExample {

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int firstArg = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer");
            }
        } else {
            System.err.println("Please, provide any number");
        }
    }
}
