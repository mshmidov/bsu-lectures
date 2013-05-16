package org.exadel.bsu.tasks.second.midtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author skrauchenia
 */
@Controller
public class TaskConditionController {

    @RequestMapping("/")
    public String infoForMainGroup() {
        return "main-group-info";
    }

}
