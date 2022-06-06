package com.odde.cucumber;

import feign.Response;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountsSteps {
    @Autowired
    private AccountsClient accountsClient;

    @Autowired
    private UsersClient usersClient;

    @When("add account as name {string} and balance {int}")
    public void add_account_as_name_and_balance(String name, Integer amount) {
        Response response = usersClient.signIn(new User("zbcjackson@gmail.com", "password"));
        String authorization = response.headers().get("Authorization").stream().findFirst().get();
        Config.Feign.authorization = authorization;
        accountsClient.addAccount(new Account(name, amount));
    }
    @Then("you will see all accounts as below")
    public void you_will_see_all_accounts_as_below(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
}
