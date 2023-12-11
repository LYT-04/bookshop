package com.example.bookshop.DAO;

import com.example.bookshop.entity.User;

public interface RegisterDao {
    public User addUser(String username, String password, Integer phone, String address);
    public User verifyRepeatability(String username);
}
