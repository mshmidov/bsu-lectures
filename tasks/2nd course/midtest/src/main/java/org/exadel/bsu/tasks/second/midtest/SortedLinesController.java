package org.exadel.bsu.tasks.second.midtest;

import org.apache.commons.io.IOUtils;
import org.exadel.bsu.tasks.second.midtest.text.TextStudentMapper;
import org.exadel.bsu.tasks.second.midtest.util.StudentNameCoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author skrauchenia
 */
@Controller
public class SortedLinesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortedLinesController.class);

    @Autowired
    private LinesSortingValidator linesSortingValidator;

    @Autowired
    private TextStudentMapper textStudentMapper;

    @Autowired
    private WordSequenceAnswersStorage answersStorage;

    @Autowired
    private StudentNameCoder studentNameCoder;

    @RequestMapping(value = "{studentName}/sorted-sequence", method = RequestMethod.PUT)
    public void handleRequest(@PathVariable("studentName") String studentName,
                              HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        String text = IOUtils.toString(request.getInputStream());
        String fileName = textStudentMapper.get(studentName);
        boolean sortingValid = linesSortingValidator.validate(fileName, text);

        if (sortingValid) {
            LOGGER.info("{} passed successfully!", studentName);
            response.setStatus(200);
            response.getWriter().write(studentNameCoder.encode(studentName));
        } else {
            LOGGER.info("{} failed!", studentName);
            response.setStatus(500);
            answersStorage.wipeAnswers(studentName);
        }
    }
}
