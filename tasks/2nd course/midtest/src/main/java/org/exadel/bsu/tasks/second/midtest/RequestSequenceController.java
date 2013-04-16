package org.exadel.bsu.tasks.second.midtest;

import org.exadel.bsu.tasks.second.midtest.text.TextStudentMapper;
import org.exadel.bsu.tasks.second.midtest.util.StudentIdConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author skrauchenia
 */
@Controller
public class RequestSequenceController {

    @Autowired
    private WordSequenceValidator wordSequenceValidator;

    @Autowired
    private TextStudentMapper textStudentMapper;

    @Autowired
    private WordSequenceAnswersRegistrant answersRegistrant;

    @RequestMapping("{studentName}/sequence/{word1}/{word2}/{word3}/{word4}/{word5}")
    public void handleRequest(@PathVariable("studentName") String studentName,
                              @PathVariable("word1") String word1,
                              @PathVariable("word2") String word2,
                              @PathVariable("word3") String word3,
                              @PathVariable("word4") String word4,
                              @PathVariable("word5") String word5,
                              HttpServletResponse response,
                              HttpServletRequest request) {

        String studentId = StudentIdConstructor.construct(studentName, request.getRemoteAddr());
        String textFileName = textStudentMapper.get(studentId);

        boolean sequenceValid =  wordSequenceValidator.validate(textFileName, word1, word2, word3, word4, word5);
        if (sequenceValid) {
            response.setStatus(200);
            answersRegistrant.register(studentId);
        } else {
            response.setStatus(500);
            answersRegistrant.wipeAnswers(studentId);
        }
    }
}
