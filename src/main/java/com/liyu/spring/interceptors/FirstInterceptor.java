package com.liyu.spring.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by twcn on 10/7/16.
 */
public class FirstInterceptor implements HandlerInterceptor {

    /**
     * 该方法在目标方法之前被调用
     * 若返回值为true,则继续调用后续的拦截器和目标方法
     * 若返回false,则不会调用后续的拦截器和方法
     *
     * 可以考虑做权限，日志，事务等
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        System.out.println("[FirstInterceptor] preHandle");
        return true;
    }

    /**
     * 调用目标方法之后但渲染视图之前被调用
     * 可以对请求域中的属性或视图修改
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("[FirstInterceptor] postHandle");
    }

    /**
     * 渲染视图之后被调用
     * 释放资源
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("[FirstInterceptor] afterCompletion");
    }
}
