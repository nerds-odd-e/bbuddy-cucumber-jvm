@login
Feature: Accounts
  Scenario: add account
    When add account as name "CMB" and balance 1000
    Then you will see all accounts as below
      | name | balance |
      | CMB  | 1000    |
