package org.exadel.bsu.tasks.second.midtest;

import org.exadel.bsu.tasks.second.midtest.text.processors.TextProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author skrauchenia
 */
@Component
public class LinesSortingValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinesSortingValidator.class);

    @Autowired
    private TextProcessor<String> linesSortingProcessor;

    public boolean validate(String textFileName, String testSequence) {
        LOGGER.trace("Processing text from {}", textFileName);
        try {
            URI fileUri = this.getClass().getClassLoader().getResource(textFileName).toURI();
            Path textFilePath = Paths.get(fileUri);
            String text = new String(Files.readAllBytes(textFilePath));
            String sortSequence = linesSortingProcessor.process(text);

            return sortSequence.equals(testSequence);
        } catch (IOException e) {
            LOGGER.error("Failed to read text from {}", textFileName, e);
            return false;
        } catch (URISyntaxException e) {
            LOGGER.error("Failed get file URL for {}", textFileName, e);
            return false;
        }
    }
}
