package com.example.bookshop.utils;

import java.net.ConnectException;
import java.sql.*;

public class JDBCUtil {
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/shixun2";
    private static String user="root";
    private static String password="sbkill1r";
    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
         Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
            try {
                if(connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException e ){}


        }

    public static void main(String[] args) {
        System.out.println(JDBCUtil.getConnection());
    }
}

