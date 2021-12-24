package com.back.controller;

import com.back.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String tologin(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Admin admin, Model model){
        //获取用户名和密码
        String username = admin.getUsername();
        String password = admin.getPassword();
        //些处横板从数据库中获取对用户名和密码后进行判断
        if(username!=null&&username.equals("admin")&&password!=null&&password.equals("admin")){
            //将用户对象添加到Session中
//            session.setAttribute("USER_SESSION",user);
            //重定向到主页面的跳转方法
            return "/home";
        }
        model.addAttribute("msg","用户名或密码错误，请重新登录！");
        return "login";
    }
}


