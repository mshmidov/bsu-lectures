package main.java.org.exadel.bsu.lectures.second.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author skrauchenia
 */
public class IntroduceSomething {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 53; i++) {
            list.add(i);
        }

        for (int i = 1; i < 52; i++) {
            int j = i + new Random().nextInt(53 - i) - 1;
            Collections.swap(list, i, j);
        }
    }
}
