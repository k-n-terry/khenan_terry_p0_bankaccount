package dev.terry.services;

import dev.terry.entities.Account;
import dev.terry.utilities.List;

public interface AccountService{
    // This method will store paramater values for the account
    // as an object, which will be used to register the account
    // in the table.
    Account registerAccount(Account account);

    // This method will allow all account info to be retrieved and
    // stored as an object within a List.
    List<Account> allAccountsList();
}
