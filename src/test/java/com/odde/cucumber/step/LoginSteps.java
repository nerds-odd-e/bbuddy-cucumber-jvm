package com.odde.cucumber.step;

import com.odde.cucumber.api.UsersClient;
import com.odde.cucumber.api.dto.User;
import com.odde.cucumber.page.DashboardPage;
import com.odde.cucumber.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginSteps {
    @Autowired
    private LoginPage loginPage;

    @Autowired
    private DashboardPage dashboardPage;
    @Autowired
    private UsersClient usersClient;

    @When("login with email {string} and password {string}")
    public void login_with_email_and_password(String email, String password) {
        loginPage.login(email, password);
    }
    @Then("login success")
    public void login_success() {
        dashboardPage.check();
    }

    @Given("there is a user with email {string} and password {string}")
    public void thereIsAUserWithEmailAndPassword(String email, String password) {
        usersClient.signUp(new User(email, password));
    }

    @Then("login fail with message {string}")
    public void loginFailWithMessage(String message) {
        loginPage.checkErrorMessage(message);
    }
}
