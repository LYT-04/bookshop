package com.example.bookshop.service.impl;

import com.example.bookshop.DAO.Impl.RegisterDaoImpl;
import com.example.bookshop.DAO.RegisterDao;
import com.example.bookshop.dto.UserDto;
import com.example.bookshop.entity.User;
import com.example.bookshop.service.RegisterService;


public class RegisterServiceImpl implements RegisterService {
    private RegisterDao registerDao = new RegisterDaoImpl();


    @Override
    public UserDto register(String username, String password, Integer phone, String address) {
        User user = this.registerDao.verifyRepeatability(username);
        UserDto userDto = new UserDto(user);
        //1、通过username查询数据库，判断账号是否重复
        //2、查询结果为空，添加注册用户
        //3、查询结果不为空，不予注册
        if (user != null) {
            userDto.setMsg("用户名已存在");
        } else {
            this.registerDao.addUser(username,password,phone,address);
        }
        return userDto;
    }
}
