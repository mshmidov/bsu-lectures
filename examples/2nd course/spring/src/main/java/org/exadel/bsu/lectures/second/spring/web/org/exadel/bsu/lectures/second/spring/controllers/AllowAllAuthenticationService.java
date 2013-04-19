package org.exadel.bsu.lectures.second.spring.web.org.exadel.bsu.lectures.second.spring.controllers;


import org.springframework.stereotype.Service;

@Service
public class AllowAllAuthenticationService implements AuthenticationService {

    @Override
    public boolean isUserAllowed(String userName) {
        return true;
    }
}
