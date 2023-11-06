package com.ll;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.List;

@NoArgsConstructor
public class SimpleDb {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private boolean devMode;

    public Sql genSql() {
        return new Sql(this);
    }

    public SimpleDb(String host, String username, String password, String dbName){
        String url = "jdbc:mysql://" + host + ":3306/" + dbName;
        try{
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public int run(String sql){
        try{
            return stmt.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public int run(String sql, String arg1, String arg2, boolean arg3){
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, arg1);
            preparedStatement.setString(2, arg2);
            preparedStatement.setBoolean(3, arg3);

            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public Long insert(String sql, List<String> strList){
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            for(int i = 0; i < strList.size(); i++){
                preparedStatement.setString(i+1, strList.get(i));
            }
            return (long) preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return (long)0;
        }
    }

    public void setDevMode(boolean b) {
        this.devMode = b;
    }
}
