package org.exadel.bsu.tasks.second.midtest;

import org.exadel.bsu.tasks.second.midtest.text.processors.TextProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author skrauchenia
 */
@Component
public class WordSequenceValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordSequenceValidator.class);

    @Autowired
    private TextProcessor<List<String>> mostPopularTextProcessor;

    @Value("#{properties.chartCapacity}")
    private int chartCapacity;

    public boolean validate(String textFileName, String ... words) {
        LOGGER.trace("Processing text from {}", textFileName);
        try {
            URI fileUri = this.getClass().getClassLoader().getResource(textFileName).toURI();
            Path textFilePath = Paths.get(fileUri);
            String text = new String(Files.readAllBytes(textFilePath));
            List<String> mostPopularWords = mostPopularTextProcessor.process(text);

            return isSequenceValid(mostPopularWords, words);
        } catch (IOException e) {
            LOGGER.error("Failed to read text from {}", textFileName, e);
            return false;
        } catch (URISyntaxException e) {
            LOGGER.error("Failed get file URL for {}", textFileName, e);
            return false;
        }
    }

    private boolean isSequenceValid(List<String> mostPopularWords, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!mostPopularWords.get(i).equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}
