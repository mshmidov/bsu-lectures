package org.exadel.bsu.lectures.second.spring.web.model;

/**
 * @author mshmidov
 */
public class User {

    private String login;

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
