package com.jamontes79.tdd_ejemplo.login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamon on 30/07/2017.
 */
public class LoginPresenterTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void checkIfLoginAttemptIsExceeded(){
        LoginPresenter loginPresenter = new LoginPresenter();
        Assert.assertEquals(1,loginPresenter.newLoginAttempt());
        Assert.assertEquals(2,loginPresenter.newLoginAttempt());
        Assert.assertEquals(3,loginPresenter.newLoginAttempt());
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }
    @Test
    public void checkIfLoginAttemptIsNotExceeded(){
        LoginPresenter loginPresenter = new LoginPresenter();
        Assert.assertFalse(loginPresenter.isLoginAttemptExceeded());
    }

    @Test
    public void checkUserAndPasswordIsCorrect(){
        LoginPresenter loginPresenter = new LoginPresenter();
        Assert.assertTrue(loginPresenter.checkUserPassword("user","password"));
    }
}