package dev.terry.data;

import dev.terry.entities.Account;
import dev.terry.utilities.*;

public interface AccountDAO{
    // CREATE
    Account createAccount(Account account);
    // READ
    Account getAccountByMainId(String mainId);
    List<Account> getAllAccounts();
    // UPDATE
    Account updateAccount(Account account, String columnName);
    // DELETE
    boolean deleteAccountBySharedId(String sharedId);
}
