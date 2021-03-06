package com.jamontes79.tdd_ejemplo.login;

/**
 * Created by jamontes79 on 30/07/2017.
 */

public class LoginPresenter {

    private final LoginView loginView;
    private int currentLoginAttempt = 0;
    private static final int MAX_LOGIN_ATTEMPT = 3;
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public LoginPresenter (LoginView loginView) {
        this.loginView = loginView;
    }
    public int newLoginAttempt() {
        return ++currentLoginAttempt;
    }

    public boolean isLoginAttemptExceeded() {
        return currentLoginAttempt >= MAX_LOGIN_ATTEMPT;
    }

    public boolean checkUserPassword(String user, String password) {
        boolean ret = true;
        if (isLoginAttemptExceeded()) {
           loginView.showErrorMessageForMaxLoginAttempt();
            ret = false;
        } else if (user.equals(USER) && password.equals(PASSWORD)) {
            loginView.showLoginSuccessMessage();
        } else {
            loginView.showErrorMessageForUserPassword();
            ret = false;
            newLoginAttempt();
        }
        return ret;
    }

}
