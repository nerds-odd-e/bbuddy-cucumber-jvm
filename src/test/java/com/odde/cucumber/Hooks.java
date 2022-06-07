package com.odde.cucumber;

import com.odde.cucumber.api.UsersClient;
import com.odde.cucumber.api.dto.User;
import com.odde.cucumber.db.AccountRepository;
import com.odde.cucumber.db.UserRepository;
import feign.Response;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersClient usersClient;

    @Before(order = 0)
    public void truncate() {
        accountRepository.truncate();
        userRepository.truncate();
    }

    @Before("@login")
    public void login() {
        usersClient.signUp(new User("zbcjackson@gmail.com", "password"));
        Response response = usersClient.signIn(new User("zbcjackson@gmail.com", "password"));
        Config.Feign.authorization = response.headers().get("Authorization").stream().findFirst().get();
    }
}
