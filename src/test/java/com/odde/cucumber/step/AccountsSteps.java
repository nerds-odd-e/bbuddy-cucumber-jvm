package com.odde.cucumber.step;

import com.odde.cucumber.api.client.AccountsClient;
import com.odde.cucumber.api.dto.Account;
import com.odde.cucumber.page.AccountsPage;
import com.odde.cucumber.page.Navigation;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AccountsSteps {
    @Autowired
    private AccountsClient accountsClient;

    @Autowired
    private AccountsPage accountsPage;

    @Autowired
    private Navigation navigation;

    @DataTableType
    public Account accountEntry(Map<String, String> entry) {
        return new Account(
                entry.get("name"),
                Integer.parseInt(entry.get("balance")));
    }

    @When("add account as name {string} and balance {int}")
    public void add_account_as_name_and_balance(String name, Integer balance) {
        navigation.accounts();
        accountsPage.addAccount(new Account(name, balance));
//        accountsClient.addAccount(new Account(name, balance));
    }

    @Then("you will see all accounts as below")
    public void you_will_see_all_accounts_as_below(List<Account> expectedAccounts) {
        accountsPage.checkAccount(expectedAccounts.get(0));
//        assertEquals(expectedAccounts, accountsClient.getAccounts());
    }
}
