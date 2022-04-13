package dev.terry.tests;

import dev.terry.data.AccountDAO;
import dev.terry.data.AccountDAO_impl;
import dev.terry.entities.Account;
import org.junit.jupiter.api.*;

public class TestData_AccountDAO{
    static AccountDAO accountDAO = new AccountDAO_impl();
    static Account testAccount = new Account();

    @Test
    void create_and_read_account(){
        /**
          * This test will create an account and get it back from the database
          * to check, whether it was created correctly.
          */
        String m01 = "fromJava01";
        String s01 = "fromJava01";
        String fn01 = "Some";
        String ln01 = "One";
        String pin01 = "12345";
        boolean sh01 = false;
        boolean sa01 = true;
        boolean ch01 = false;

        Account someOne = new Account(m01,s01,fn01,ln01,pin01,sh01,sa01,ch01);
        Account testStoredAccount = accountDAO.createAccount(someOne);
        TestData_AccountDAO.testAccount = testStoredAccount;

        Assertions.assertEquals(m01,testStoredAccount.getMainId());
    }
}
