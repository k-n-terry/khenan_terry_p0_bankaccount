package dev.terry.data;

import dev.terry.entities.Savings;
import dev.terry.utilities.ArrayList;
import dev.terry.utilities.ConnectUtil;
import dev.terry.utilities.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SavingsDAO_impl implements SavingsDAO{
    // CREATE
    @Override
    public Savings createSavings(Savings savings){
        try{
            Connection conn = ConnectUtil.createConnect();
            // conn comes from SavingsDAO_impl
            String sql = "insert into savings_account values(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            // string parameter
            ps.setString(1, savings.getSharedId());
            // double parameter
            ps.setDouble(2, savings.getSavingsBalance());

            ps.execute();

            return savings;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }
    @Override
    public Savings createSavings(Savings savings, Connection conn) {
        try {
            // conn comes from SavingsDAO_impl
            String sql = "insert into savings_account values(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            // string parameter
            ps.setString(1, savings.getSharedId());
            // double parameter
            ps.setDouble(2, savings.getSavingsBalance());

            ps.execute();

            return savings;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    // READ
    @Override
    public Savings getSavingsBySharedId(String sharedId){
        try{
            Connection conn = ConnectUtil.createConnect();
            String sql = "select * from savings_account where shared_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            // string parameter
            ps.setString(1, sharedId);

            ResultSet rs = ps.executeQuery();

            rs.next();

            // store table data in savings object
            Savings savings = new Savings();
            // string data
            savings.setSharedId(rs.getString("shared_id"));
            // double data
            savings.setSavingsBalance(rs.getDouble("savings_balance"));

            return savings;
        }catch(SQLException e){
            e.printStackTrace();

            return null;
        }
    }
    @Override
    public List<Savings> getAllSavings(){
        try{
            Connection conn = ConnectUtil.createConnect();
            String sql = "select * from savings_account";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Savings> allSavingss = new ArrayList();
            while(rs.next()){
                Savings savings = new Savings();

                // string data
                savings.setSharedId(rs.getString("shared_id"));
                // boolean data
                savings.setSavingsBalance(rs.getDouble("savings_balance"));
                allSavingss.add(savings);
            }
            return allSavingss;
        }catch(SQLException e){
            e.printStackTrace();

            return null;
        }
    }

    // UPDATE
    @Override
    public Savings updateSavings(Savings savings, String columnName){
        try{
            Connection conn = ConnectUtil.createConnect();
            String sql = "update savings_account set "+columnName+" = ? where shared_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            switch(columnName){
                // string parameters
                case("shared_id"):
                    ps.setString(1, savings.getSharedId());
                    break;
                case("savings_balance"):
                    ps.setDouble(1, savings.getSavingsBalance());
                    break;
                default:
                    String exceptionMessage = "Invalid column name: Input a valid column name.";
                    throw new Exception(exceptionMessage);
            }
            ps.setString(2, savings.getSharedId());

            ps.executeUpdate();

            return savings;
        }catch(Exception e){
            e.printStackTrace();

            return null;
        }
    }
    // DELETE
    @Override
    public boolean deleteSavingsBySharedId(String sharedId){
        try{
            Connection conn = ConnectUtil.createConnect();

            // delete savings_account record
            String sqlSavings = "delete from savings_account where shared_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sqlSavings);
            ps.setString(1, sharedId);
            ps.execute();

            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
