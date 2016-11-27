package com.leapfrog.sjn.DBConnection;

import com.leapfrog.sjn.Constant.DbConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    
    public void open() throws ClassNotFoundException, SQLException{
        Class.forName(DbConstant.DB_DRIVER);
        conn = DriverManager.getConnection(DbConstant.DB_URL, DbConstant.DB_USER, DbConstant.DB_PASSWORD);
    }
    public PreparedStatement initStatement(String Sql) throws SQLException{
        stmt = conn.prepareStatement(Sql);
        return stmt;
    }
    public int executeUpdate() throws SQLException{
        return stmt.executeUpdate();
    }
    public ResultSet executeQuery() throws SQLException{
        return stmt.executeQuery();
    }
    public void close() throws SQLException{
        if(conn!=null && !conn.isClosed()){
            conn.close();
            conn = null;
        }
    }
}
