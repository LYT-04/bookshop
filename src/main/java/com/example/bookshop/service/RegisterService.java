package com.example.bookshop.service;

import com.example.bookshop.dto.UserDto;

public interface RegisterService {
    public UserDto register(String username, String password,Integer phone,String address);
}
