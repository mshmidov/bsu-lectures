package org.exadel.bsu.tasks.second.midtest.text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skrauchenia
 */
@Component
public class TextStudentMapper extends HashMap<String, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextStudentMapper.class);

    private Map<String, String> mapping = new HashMap<>();

    public String put(String studentId, String bookFileName) {
        String oldValue = mapping.put(studentId, bookFileName);
        printInfoAboutMapping(studentId, bookFileName, oldValue);
        return oldValue;
    }

    public String get(Object studentId) {
        return mapping.get(studentId);
    }

    private void printInfoAboutMapping(String studentId, String bookFileName, String oldValue) {
        if (oldValue == null) {
            LOGGER.info("{} mapped to book {}", studentId, bookFileName);
        } else if (!oldValue.equals(bookFileName)) {
            LOGGER.info("Mapping for {} changed from {} to {}", new Object[] {studentId, oldValue, bookFileName});
        } else {
            LOGGER.info("{} re-mapped to the same book: {}", studentId, bookFileName);
        }
    }
}
