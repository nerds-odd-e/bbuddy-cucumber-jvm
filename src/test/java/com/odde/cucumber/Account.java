package com.odde.cucumber;

public class Account {
    private String name;
    private Integer balance;

    public Account(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }
}
