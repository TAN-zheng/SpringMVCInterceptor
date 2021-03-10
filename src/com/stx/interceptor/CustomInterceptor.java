package com.stx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 实现HandlerInterceptor接口自定义拦截器
 * */
public class CustomInterceptor implements HandlerInterceptor {
    /*
    * 这个拦截器会在，controller类执行前进行拦截。
    * */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("CustomerInterceptor...preHandle");
        return true;
    }
    /*
    *这个拦截器会在， 解析视图前执行。ViewResolver进行解析前进行处理。
    * */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("CustomerInterceptor...postHandle");
    }
    /*
    * 这个拦截器会在，视图渲染后执行。
    * */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("CustomerInterceptor...afterCompletion");
    }
}
