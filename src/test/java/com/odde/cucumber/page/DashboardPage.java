package com.odde.cucumber.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashboardPage {

    @Autowired
    private Ui ui;

    public void check() {
        ui.assertHaveText("Dashboard");
    }
}
