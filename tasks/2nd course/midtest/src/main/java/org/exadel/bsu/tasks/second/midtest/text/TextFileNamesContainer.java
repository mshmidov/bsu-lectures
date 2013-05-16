package org.exadel.bsu.tasks.second.midtest.text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author skrauchenia
 */
@Component
public class TextFileNamesContainer {

    @Autowired
    @Qualifier("bookFiles")
    // TODO: should be changed to List. For some reason spring don't want to work with List O.o
    private ArrayList<String> books;
    private Random random = new Random();

    public String pickUpNameRandomly() {
        return books.get(random.nextInt(books.size()));
    }
}
