package com.stx.controller;

import com.stx.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    /**
     * 向用户登录页面跳转
     * */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){

        return "login";
    }
    /**
     * 用户登录
     * */

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session){

        String username = user.getUsername();
        String password = user.getPassword();
//        判断用户名，密码，非空。
        if (username!=null && username.equals("xiaoxue")&& password!=null &&password.equals("123456")){
//          将用户对象添加到Session
            session.setAttribute("USER_SESSION",user);
//          重定向到主页面的跳转方法。
            return "redirect:main";
        }
//        如果不对就跳转到登录页面
        model.addAttribute("msg","用户名或密码错误，请重新登陆！");
        return "login";
    }
    /**
     * 向用户主页面跳转
     * */
    @RequestMapping(value = "/main")
    public String toMain(){

        return "main";
    }
    /**
     * 退出登录
     * */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
//        清除Session
        session.invalidate();
//        重定向到登录页面的跳转方法
        return "redirect:login";
    }
}
