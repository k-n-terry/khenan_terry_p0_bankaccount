package dev.terry.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectUtil{
    public static Connection createConnect(){
        try{
            Connection conn = DriverManager.getConnection(System.getenv("KHENAN_TERRY_P0"));
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}