package com.odde.cucumber;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "accountsClient", url = "http://localhost:8080")
public interface AccountsClient {
    @PostMapping("/accounts")
    @Headers("Content-Type: application/json")
    void addAccount(@RequestBody Account account);

    @GetMapping("/accounts")
    List<Account> getAccounts();
}
