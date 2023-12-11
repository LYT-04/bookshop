package com.example.bookshop.DAO;

import com.example.bookshop.entity.User;

public interface LoginDao {
    public User findByUsername(String username);

}
