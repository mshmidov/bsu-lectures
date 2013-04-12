package org.exadel.bsu.lectures.second.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRoot() {
        return getIndex();
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String getIndex() {
       return "index";
    }




}
