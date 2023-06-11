package com.lynu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/login.a")
    public String loginIn(String adminCode, String adminPwd, String valiCode, String checkFlag, HttpSession session, HttpServletResponse response){
        if (valiCode.equals(session.getAttribute("valiCode"))){
            Admin admin = loginService.loginAdminService(adminCode, adminPwd);
            if (admin != null){
                if (checkFlag != null){
                    Cookie cookie = new Cookie("aCode", adminCode);
                    Cookie cookie1 = new Cookie("aPwd", adminPwd);
                    cookie.setMaxAge(60*60*24*14);
                    cookie1.setMaxAge(60*60*24*14);
                    cookie.setPath("/");
                    cookie1.setPath("/");
                    response.addCookie(cookie);
                    response.addCookie(cookie1);
                }else {
                    Cookie cookie = new Cookie("aCode", adminCode);
                    Cookie cookie1 = new Cookie("aPwd", adminPwd);
                    cookie.setMaxAge(0);
                    cookie1.setMaxAge(0);
                    cookie.setPath("/");
                    cookie1.setPath("/");
                    response.addCookie(cookie);
                    response.addCookie(cookie1);
                }
//                System.out.println("admin = " + admin);
                session.setAttribute("admin",admin);
                return "page/index";
            }else {
                return "page/login";
            }
        }else {
            return "page/login";
        }
    }
}
