package org.exadel.bsu.tasks.second.midtest.text.processors;

/**
 * @author skrauchenia
 */
public interface TextProcessor<RESULT> {

    RESULT process(String text);
}
