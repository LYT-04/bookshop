package com.example.bookshop.dto;

import com.example.bookshop.entity.User;

public class UserDto {
    private String msg;
    private User user;

    public UserDto() {
    }

    public UserDto(User user) {
        this.user = user;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
