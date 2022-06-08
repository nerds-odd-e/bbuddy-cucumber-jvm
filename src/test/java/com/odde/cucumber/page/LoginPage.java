package com.odde.cucumber.page;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {
    @Autowired
    private Ui ui;

    public void login(String email, String password) {
        ui.open("http://localhost:8100/#/signin");
        ui.input("email", email);
        ui.input("password", password);
        ui.click("login");
    }

    public void checkErrorMessage(String message) {
        ui.assertHaveText(message);
    }
}
