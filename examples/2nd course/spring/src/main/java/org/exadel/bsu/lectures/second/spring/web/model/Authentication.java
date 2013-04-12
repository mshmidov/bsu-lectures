package org.exadel.bsu.lectures.second.spring.web.model;

/**
 * @author mshmidov
 */
public class Authentication {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isUserLogged() {
        return user != null;
    }

    public String getLoggedUserName() {
        return (isUserLogged())
               ? user.getLogin()
               : "";
    }
}
