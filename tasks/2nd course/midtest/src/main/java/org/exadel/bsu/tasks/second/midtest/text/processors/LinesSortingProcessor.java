package org.exadel.bsu.tasks.second.midtest.text.processors;

import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

/**
 * @author skrauchenia
 */
@Component
public class LinesSortingProcessor implements TextProcessor<String> {

    @Override
    public String process(String text) {
        String[] lines = text.split("\\n");
        Set<String> sortedLines = Sets.newTreeSet(Arrays.asList(lines));
        StringBuilder result = new StringBuilder();
        for (String sortedLine : sortedLines) {
            if (!sortedLine.isEmpty()) {
                result.append(sortedLine.charAt(0));
            }
        }
        return result.toString();
    }
}
