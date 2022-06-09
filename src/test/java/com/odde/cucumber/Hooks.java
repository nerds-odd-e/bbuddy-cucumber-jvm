package com.odde.cucumber;

import com.odde.cucumber.api.Api;
import com.odde.cucumber.api.dto.User;
import com.odde.cucumber.db.AccountRepository;
import com.odde.cucumber.db.UserRepository;
import com.odde.cucumber.page.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Api api;

    @Autowired
    private LoginPage loginPage;

    @Before(order = 0)
    public void truncate() {
        accountRepository.truncate();
        userRepository.truncate();
    }

    @Before("@login")
    public void login() {
        api.signUp(new User("zbcjackson@odd-e.com", "password"));
        loginPage.login("zbcjackson@odd-e.com", "password");
        api.signIn(new User("zbcjackson@odd-e.com", "password"));
    }

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

}
