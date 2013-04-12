package org.exadel.bsu.lectures.second.spring.web.controllers;

import org.exadel.bsu.lectures.second.spring.web.model.CustomJsonRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomJsonFormController {

    @RequestMapping(value = "/forms/custom-json", method = RequestMethod.GET)
    public ModelAndView getCustomJson() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(new CustomJsonRequest("name", "value"));
        modelAndView.setViewName("custom-json-form");
        return modelAndView;

    }

    @RequestMapping(value = "/forms/custom-json", method = RequestMethod.POST)
    public String postCustomJson(@ModelAttribute CustomJsonRequest customJsonRequest) {
        return String.format("redirect:/resource/json/name/%s/value/%s",
                customJsonRequest.getName(),
                customJsonRequest.getValue());
    }

}
