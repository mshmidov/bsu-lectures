package org.exadel.bsu.tasks.second.midtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Simple index page controller serving hello.jsp file 
 */
@Controller
public class PassedListController {

    @Autowired
    private WordSequenceAnswersRegistrant answersRegistrant;

    /**
     * Simply serves hello.jsp
     * @return view with name 'hello'
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView handleRequest() {
        ModelAndView modelAndView = new ModelAndView("passed-list");
        modelAndView.addObject("passedStudents", answersRegistrant.getAll());
        return modelAndView;
    }

}
