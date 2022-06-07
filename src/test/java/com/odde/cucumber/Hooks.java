package com.odde.cucumber;

import com.odde.cucumber.db.AccountRepository;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void truncate() {
        accountRepository.truncate();
    }
}
