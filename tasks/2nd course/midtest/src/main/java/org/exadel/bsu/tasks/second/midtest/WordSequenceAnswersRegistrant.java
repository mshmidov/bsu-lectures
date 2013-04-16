package org.exadel.bsu.tasks.second.midtest;

import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author skrauchenia
 */
@Component
public class WordSequenceAnswersRegistrant {

    private Set<String> students = Sets.newHashSet();

    public void register(String studentId) {
        students.add(studentId);
    }

    public void wipeAnswers(String studentId) {
        students.remove(studentId);
    }
}
