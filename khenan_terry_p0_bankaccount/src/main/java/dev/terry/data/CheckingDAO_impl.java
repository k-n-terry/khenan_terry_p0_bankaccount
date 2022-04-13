package dev.terry.data;

import dev.terry.entities.Checking;
import dev.terry.utilities.ArrayList;
import dev.terry.utilities.ConnectUtil;
import dev.terry.utilities.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckingDAO_impl implements CheckingDAO{
    // CREATE
    @Override
    public Checking createChecking(Checking checking){
        try{
            Connection conn = ConnectUtil.createConnect();
            // conn comes from CheckingDAO_impl
            String sql = "insert into checking_account values(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            // string parameter
            ps.setString(1, checking.getSharedId());
            // double parameter
            ps.setDouble(2, checking.getCheckingBalance());

            ps.execute();

            return checking;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }
    @Override
    public Checking createChecking(Checking checking, Connection conn) {
        try {
            // conn comes from CheckingDAO_impl
            String sql = "insert into checking_account values(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            // string parameter
            ps.setString(1, checking.getSharedId());
            // double parameter
            ps.setDouble(2, checking.getCheckingBalance());

            ps.execute();

            return checking;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    // READ
    @Override
    public Checking getCheckingBySharedId(String sharedId){
        try{
            Connection conn = ConnectUtil.createConnect();
            String sql = "select * from checking_account where shared_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            // string parameter
            ps.setString(1, sharedId);

            ResultSet rs = ps.executeQuery();

            rs.next();

            // store table data in checking object
            Checking checking = new Checking();
            // string data
            checking.setSharedId(rs.getString("shared_id"));
            // double data
            checking.setCheckingBalance(rs.getDouble("checking_balance"));

            return checking;
        }catch(SQLException e){
            e.printStackTrace();

            return null;
        }
    }
    @Override
    public List<Checking> getAllChecking(){
        try{
            Connection conn = ConnectUtil.createConnect();
            String sql = "select * from checking_account";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Checking> allCheckings = new ArrayList();
            while(rs.next()){
                Checking checking = new Checking();

                // string data
                checking.setSharedId(rs.getString("shared_id"));
                // boolean data
                checking.setCheckingBalance(rs.getDouble("checking_balance"));
                allCheckings.add(checking);
            }
        return allCheckings;
        }catch(SQLException e){
            e.printStackTrace();

            return null;
        }
    }

    // UPDATE
    @Override
    public Checking updateChecking(Checking checking, String columnName){
        try{
        Connection conn = ConnectUtil.createConnect();
        String sql = "update checking_account set "+columnName+" = ? where shared_id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);

        switch(columnName){
            // string parameters
            case("shared_id"):
                ps.setString(1, checking.getSharedId());
                break;
            case("checking_balance"):
                ps.setDouble(1, checking.getCheckingBalance());
                break;
            default:
                String exceptionMessage = "Invalid column name: Input a valid column name.";
                throw new Exception(exceptionMessage);
        }
        ps.setString(2, checking.getSharedId());

        ps.executeUpdate();

        return checking;
        }catch(Exception e){
            e.printStackTrace();

            return null;
        }
    }
    // DELETE
    @Override
    public boolean deleteCheckingBySharedId(String sharedId){
        try{
            Connection conn = ConnectUtil.createConnect();

            // delete checking_account record
            String sqlChecking = "delete from checking_account where shared_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sqlChecking);
            ps.setString(1, sharedId);
            ps.execute();

            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
