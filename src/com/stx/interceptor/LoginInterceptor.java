package com.stx.interceptor;

import com.stx.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//      获取请求的URL
        String url=httpServletRequest.getRequestURI();
//      除了login.jsp是可以公开访问的，其他的URL都进行拦截控制。
//      url.indexOf()方法为在 字符串url中查找“login”首次出现的位置
        if (url.indexOf("/login")>0){
            return true;
        }
//      获取session
        HttpSession session = httpServletRequest.getSession();
        User user= (User) session.getAttribute("USER_SESSION");
        if (user!=null){
            return true;
        }
        httpServletRequest.setAttribute("msg","您还没有登录，请先登录！");
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(httpServletRequest,httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
