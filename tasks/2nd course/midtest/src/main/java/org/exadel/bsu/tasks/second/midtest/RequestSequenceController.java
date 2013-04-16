package org.exadel.bsu.tasks.second.midtest;

import org.exadel.bsu.tasks.second.midtest.text.TextStudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author skrauchenia
 */
@Controller
public class RequestSequenceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestSequenceController.class);

    @Autowired
    private WordSequenceValidator wordSequenceValidator;

    @Autowired
    private TextStudentMapper textStudentMapper;

    @Autowired
    private WordSequenceAnswersStorage answersStorage;

    @RequestMapping("{studentId}/sequence/{word1}/{word2}/{word3}/{word4}/{word5}")
    public void handleRequest(@PathVariable("studentId") String studentId,
                              @PathVariable("word1") String word1,
                              @PathVariable("word2") String word2,
                              @PathVariable("word3") String word3,
                              @PathVariable("word4") String word4,
                              @PathVariable("word5") String word5,
                              HttpServletResponse response) {

        String textFileName = textStudentMapper.get(studentId);

        if (textFileName == null) {
            throw new IllegalStateException("First you should acquire text");
        }

        boolean sequenceValid =  wordSequenceValidator.validate(textFileName, word1, word2, word3, word4, word5);
        if (sequenceValid) {
            LOGGER.info("{} passed successfully!", studentId);
            response.setStatus(200);
            answersStorage.register(studentId);
        } else {
            LOGGER.info("{} failed!", studentId);
            response.setStatus(500);
            answersStorage.wipeAnswers(studentId);
        }
    }
}
