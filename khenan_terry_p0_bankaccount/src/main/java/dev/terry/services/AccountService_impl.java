package dev.terry.services;

import dev.terry.data.AccountDAO;
import dev.terry.entities.Account;
import dev.terry.utilities.List;

public class AccountService_impl implements AccountService{
    private AccountDAO accountDAO;

    public AccountService_impl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public Account registerAccount(Account account){
        return this.accountDAO.createAccount(account);
    }

    @Override
    public List<Account> allAccountsList(){
        return this.accountDAO.getAllAccounts();
    }
}
