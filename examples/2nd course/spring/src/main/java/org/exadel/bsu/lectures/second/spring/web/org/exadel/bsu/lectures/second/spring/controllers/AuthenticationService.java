package org.exadel.bsu.lectures.second.spring.web.org.exadel.bsu.lectures.second.spring.controllers;


import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    boolean isUserAllowed(String userName);

}
