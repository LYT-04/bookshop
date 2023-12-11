package com.example.bookshop.service;

import com.example.bookshop.dto.UserDto;

public interface LoginService {
    public UserDto login(String username, String password);

}
