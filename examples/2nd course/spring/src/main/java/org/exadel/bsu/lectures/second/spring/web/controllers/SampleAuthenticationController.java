package org.exadel.bsu.lectures.second.spring.web.controllers;

import org.exadel.bsu.lectures.second.spring.web.model.Authentication;
import org.exadel.bsu.lectures.second.spring.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("authentication")
public class SampleAuthenticationController {

    @ModelAttribute
    public Authentication newAuthentication() {
        return new Authentication();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUserInfo(@ModelAttribute Authentication authentication) {

        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName((authentication.isUserLogged())
                                 ? "existing-user"
                                 : "redirect:/user/login");

        return modelAndView;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public ModelAndView getLogon(@ModelAttribute Authentication authentication) {
        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName((authentication.isUserLogged())
                                 ? "redirect:/user"
                                 : "login");

        return modelAndView;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ModelAndView postLogon(@RequestParam String userName, @ModelAttribute Authentication authentication) {
        final ModelAndView modelAndView = new ModelAndView();

        if (!authentication.isUserLogged()) {
            authentication.setUser(new User(userName));
        }

        modelAndView.setViewName("redirect:/user");

        return modelAndView;
    }

    @RequestMapping(value = "/user/logoff", method = RequestMethod.POST)
    public ModelAndView postLogoff(@ModelAttribute Authentication authentication, SessionStatus sessionStatus) {
        final ModelAndView modelAndView = new ModelAndView();

        authentication.setUser(null);

        modelAndView.setViewName("redirect:/user");

        sessionStatus.setComplete();

        return modelAndView;
    }
}
