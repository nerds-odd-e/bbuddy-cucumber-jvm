package com.odde.cucumber;

import com.odde.cucumber.api.dto.Account;
import com.odde.cucumber.api.AccountsClient;
import com.odde.cucumber.api.dto.User;
import com.odde.cucumber.api.UsersClient;
import feign.Response;
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
    private UsersClient usersClient;

    @DataTableType
    public Account accountEntry(Map<String, String> entry) {
        return new Account(
                entry.get("name"),
                Integer.parseInt(entry.get("balance")));
    }

    @When("add account as name {string} and balance {int}")
    public void add_account_as_name_and_balance(String name, Integer amount) {
        Response response = usersClient.signIn(new User("zbcjackson@gmail.com", "password"));
        String authorization = response.headers().get("Authorization").stream().findFirst().get();
        Config.Feign.authorization = authorization;
        accountsClient.addAccount(new Account(name, amount));
    }
    @Then("you will see all accounts as below")
    public void you_will_see_all_accounts_as_below(List<Account> expectedAccounts) {
        List<Account> accounts = accountsClient.getAccounts();
        assertEquals(expectedAccounts, accounts);
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }
}
