package com.odde.cucumber.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Navigation {
    @Autowired
    private Ui ui;

    public void accounts() {
        ui.click("Accounts");
    }
}
