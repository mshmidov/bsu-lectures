package org.exadel.bsu.tasks.second.midtest;

import org.exadel.bsu.tasks.second.midtest.text.TextStudentMapper;
import org.exadel.bsu.tasks.second.midtest.util.StudentNameCoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author skrauchenia
 */
@Controller
public class RegisterStudentController {

    @Autowired
    private StudentNameCoder studentNameCoder;

    @Autowired
    private TextStudentMapper textStudentMapper;

    @Autowired
    private WordSequenceAnswersStorage storage;

    @RequestMapping("/register/{registerKey}")
    public void register(@PathVariable("registerKey") String registerKey,
                         HttpServletResponse response) {

        String studentName = studentNameCoder.decode(registerKey);
        String studentTextFileName = textStudentMapper.get(studentName);
        boolean studentAcquireText = studentTextFileName != null;
        if (studentAcquireText) {
            response.setStatus(200);
            storage.register(studentName);
        } else {
            response.setStatus(500);
            storage.wipeAnswers(studentName);
        }
    }
}
