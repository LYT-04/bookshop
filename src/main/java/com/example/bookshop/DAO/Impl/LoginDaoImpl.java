package com.example.bookshop.DAO.Impl;

import com.example.bookshop.DAO.LoginDao;
import com.example.bookshop.entity.User;
import com.example.bookshop.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {

    @Override
    public User findByUsername(String username) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from  shixun2.user  where username = '"+username+"' ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                username = resultSet.getString(2);
                String password = resultSet.getString(3);
                int phone = resultSet.getInt(4);
                String address = resultSet.getString(5);
                return new User(id,username, password, phone, address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.release(connection,statement,resultSet);
        }
        return null;
    }
}
