package com.example.bookshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCUtilTest {
    public static void main(String[] args) {

            String url = "jdbc:mysql://localhost:3306/shixun2?CharacterEncoding=utf8&useSSL=false";
            String username = "root";
            String password = "sbkill1r";

            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                // 使用连接执行数据库操作
                // ...
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }

}