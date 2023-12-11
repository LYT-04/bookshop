package com.example.bookshop.controller;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.service.RegisterService;
import com.example.bookshop.service.impl.RegisterServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private RegisterService registerService = new RegisterServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("regUsername");
        String password = req.getParameter("regPassword");
        Integer phone = Integer.valueOf(req.getParameter("regPhone"));
        String address = req.getParameter("regAddress");

        UserDto userDto = this.registerService.register(username, password,phone,address);
        System.out.println(userDto.getMsg());
        if ("用户名已存在".equals(userDto.getMsg())){
            req.setAttribute("usernameAlreadyExist","用户名已存在");
        }else {
            resp.sendRedirect("/login.jsp");
            System.out.println("注册成功");
        }

    }

}
