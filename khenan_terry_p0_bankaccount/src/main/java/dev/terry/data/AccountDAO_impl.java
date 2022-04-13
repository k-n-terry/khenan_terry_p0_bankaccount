package dev.terry.data;

import dev.terry.entities.Account;
import dev.terry.utilities.ArrayList;
import dev.terry.utilities.ConnectUtil;
import dev.terry.utilities.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO_impl implements AccountDAO{
    // CREATE
    @Override
    public Account createAccount(Account account){
        try{
            // connects to database
            Connection conn = ConnectUtil.createConnect();

            // formats the SQL statement
            String sql = "insert into account_registry values(?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            // string parameters
            ps.setString(1, account.getMainId());
            ps.setString(2, account.getSharedId());
            ps.setString(3, account.getFirstName());
            ps.setString(4, account.getLastName());
            ps.setString(5, account.getAccountPin());
            // boolean parameters
            ps.setBoolean(6, account.getShareState());
            ps.setBoolean(7, account.getSavingsState());
            ps.setBoolean(8, account.getCheckingState());

            ps.execute();

            return account;
        }catch(SQLException e){
            e.printStackTrace();

            return null;
        }
    }

    // READ
    @Override
    public Account getAccountByMainId(String mainId){
        try{
            Connection conn = ConnectUtil.createConnect();
            String sql = "select * from account_registry where main_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            // string parameter
            ps.setString(1, mainId);

            ResultSet rs = ps.executeQuery();

            rs.next();

            // store table data in account object
            Account account = new Account();
            // string data
            account.setMainId(rs.getString("main_id"));
            account.setSharedId(rs.getString("shared_id"));
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setAccountPin(rs.getString("account_pin"));
            // boolean data
            account.setShareState(rs.getBoolean("share_state"));
            account.setSavingsState(rs.getBoolean("savings_state"));
            account.setCheckingState(rs.getBoolean("checking_state"));

            return account;
        }catch(SQLException e){
            e.printStackTrace();

            return null;
        }
    }
    @Override
    public List<Account> getAllAccounts(){
        try {
            Connection conn = ConnectUtil.createConnect();
            String sql = "select * from account_registry";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Account> allAccounts = new ArrayList();
            while(rs.next()){
                Account account = new Account();

                // string data
                account.setMainId(rs.getString("main_id"));
                account.setSharedId(rs.getString("shared_id"));
                account.setFirstName(rs.getString("first_name"));
                account.setLastName(rs.getString("last_name"));
                account.setAccountPin(rs.getString("account_pin"));
                // boolean data
                account.setShareState(rs.getBoolean("share_state"));
                account.setSavingsState(rs.getBoolean("savings_state"));
                account.setCheckingState(rs.getBoolean("checking_state"));
                allAccounts.add(account);
            }
        return allAccounts;
        }catch(SQLException e){
            e.printStackTrace();

            return null;
        }
    }
    // UPDATE
    @Override
    public Account updateAccount(Account account, String columnName){
        try{
        Connection conn = ConnectUtil.createConnect();
        String sql = "update account_registry set "+columnName+" = ? where main_id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);

        switch(columnName){
            // string parameters
            case("main_id"):
                ps.setString(1, account.getMainId());
                break;
            case("shared_id"):
                ps.setString(1, account.getSharedId());
                break;
            case("first_name"):
                ps.setString(1, account.getFirstName());
                break;
            case("last_name"):
                ps.setString(1, account.getLastName());
                break;
            case("account_pin"):
                ps.setString(1, account.getAccountPin());
                break;
            // boolean parameters
            case("share_state"):
                ps.setBoolean(1, account.getShareState());
                break;
            case("savings_state"):
                ps.setBoolean(1, account.getSavingsState());
                break;
            case("checking_state"):
                ps.setBoolean(1, account.getCheckingState());
                break;
            default:
                String exceptionMessage = "Invalid column name: Input a valid column name.";
                throw new Exception(exceptionMessage);
        }
        ps.setString(2, account.getMainId());

        ps.executeUpdate();

        return account;
        }catch(Exception e){
            e.printStackTrace();

            return null;
        }
    }

    // DELETE
    @Override
    public boolean deleteAccountBySharedId(String sharedId){
        try{
            Connection conn = ConnectUtil.createConnect();

            // need to remove child-records first
            // delete savings_account record
            String sqlSavings = "delete from savings_account where shared_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sqlSavings);
            ps.setString(1, sharedId);
            ps.execute();

            // delete checking_account record
            String sqlChecking = "delete from checking_account where shared_id = ?;";
            ps = conn.prepareStatement(sqlChecking);
            ps.setString(1, sharedId);
            ps.execute();

            // delete ledger record
            String sqlLedger = "delete from ledger where shared_id = ?;";
            ps = conn.prepareStatement(sqlLedger);
            ps.setString(1, sharedId);
            ps.execute();

            // delete account_registry record

            String sqlAccount = "delete from account_registry where shared_id = ?;";
            ps = conn.prepareStatement(sqlAccount);
            ps.setString(1, sharedId);
            ps.execute();

            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
