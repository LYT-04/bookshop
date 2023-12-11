package com.example.bookshop.controller;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.service.LoginService;
import com.example.bookshop.service.impl.LoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Time;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("loginUsername");
        String password = req.getParameter("loginPassword");
//        System.out.println(username);
//        System.out.println(password);
        UserDto userDto = this.loginService.login(username, password);
        System.out.println(userDto.getMsg());
        switch (userDto.getMsg()) {
            case "用户名不存在" -> {
                req.setAttribute("usernameError","用户名不存在");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
            case "密码错误" -> {
                req.setAttribute("passwordError","密码错误");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
            case"登录成功"->{
                resp.sendRedirect("/main.jsp");
                System.out.println("登录成功");
            }
        }


    }
}
