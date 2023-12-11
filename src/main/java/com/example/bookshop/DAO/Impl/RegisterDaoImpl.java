package com.example.bookshop.DAO.Impl;

import com.example.bookshop.DAO.RegisterDao;
import com.example.bookshop.entity.User;
import com.example.bookshop.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDaoImpl implements RegisterDao {



    @Override
    public User addUser(String username, String password, Integer phone, String address) {
        Connection connection = JDBCUtil.getConnection();
//        String sql = "insert into shixun2.user (?,"+username+", "+password+", "+phone+", "+address+") value (?,?,?,?,?)";
        String sql = "insert into shixun2.user(username,password,phone,address) values (?,?,?,?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            int rows = statement.executeUpdate();
            resultSet =statement.executeQuery();
//            resultSet = statement.executeQuery("SELECT * FROM shixun2.user WHERE id = ?", new Object[]{rows});

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                username = resultSet.getString(2);
                password = resultSet.getString(3);
                phone = resultSet.getInt(4);
                address = resultSet.getString(5);
                return new User(id,username, password, phone, address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.release(connection,statement,resultSet);
        }
        return null;
    }

    @Override
    public User verifyRepeatability(String username) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from  shixun2.user  where username = '"+username+"' ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                username = resultSet.getString(2);
                return new User(username);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.release(connection,statement,resultSet);
        }
        return null;
    }

}
