package com.odde.cucumber.page;

import com.odde.cucumber.api.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountsPage {
    @Autowired
    private Ui ui;

    public void addAccount(Account account) {
        ui.clickByText("Add");
        ui.input("name", account.getName());
        ui.input("balance", String.valueOf(account.getBalance()));
        ui.clickByText("Save");
    }

    public void checkAccount(Account account) {
        ui.assertHaveText(account.getName());
        ui.assertHaveText(account.getBalance().toString());
    }
}
