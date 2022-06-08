package com.odde.cucumber;

import com.odde.cucumber.api.Feign;
import com.odde.cucumber.api.UsersClient;
import com.odde.cucumber.api.dto.User;
import com.odde.cucumber.db.AccountRepository;
import com.odde.cucumber.db.UserRepository;
import com.odde.cucumber.page.LoginPage;
import feign.Response;
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
    private UsersClient usersClient;

    @Autowired
    private LoginPage loginPage;

    @Before(order = 0)
    public void truncate() {
        accountRepository.truncate();
        userRepository.truncate();
    }

    @Before("@login")
    public void login() {
        usersClient.signUp(new User("zbcjackson@odd-e.com", "password"));
        loginPage.login("zbcjackson@odd-e.com", "password");
        Response response = usersClient.signIn(new User("zbcjackson@odd-e.com", "password"));
        Feign.authorization = response.headers().get("Authorization").stream().findFirst().get();
    }

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

}
