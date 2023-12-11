package com.example.bookshop.service.impl;

import com.example.bookshop.DAO.Impl.LoginDaoImpl;
import com.example.bookshop.DAO.LoginDao;
import com.example.bookshop.dto.UserDto;
import com.example.bookshop.entity.User;
import com.example.bookshop.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao = new LoginDaoImpl();
    @Override
    public UserDto login(String username, String password) {
        //1、通过username查询数据库
        //2、查询结果为空，username错误
        //3、查询结果不为空，再判断password是否正确
        User user = this.loginDao.findByUsername(username);
        UserDto userDto = new UserDto(user);
        if(user == null){
            userDto.setMsg("用户名不存在");
        }else{
            if(!user.getPassword().equals(password)){
                userDto.setMsg("密码错误");
            }else{
                userDto.setMsg("登录成功");
                userDto.setUser(user);
            }
        }
        return userDto;
    }
}
