package com.jamontes79.tdd_ejemplo.login;

/**
 * Created by jamontes79 on 31/07/2017.
 */

public interface LoginView {

    void showErrorMessageForUserPassword();

    void showErrorMessageForMaxLoginAttempt();

    void showLoginSuccessMessage();
}
