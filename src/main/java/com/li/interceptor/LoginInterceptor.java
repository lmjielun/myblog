package com.li.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  登录过滤
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
    /**
     * 登录前过滤，如果未登录不能访问某些资源
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("*********拦截器执行");
        // 判断User是否为null，为null就让他去登录
        if(request.getSession().getAttribute("user")==null){
            System.out.println("**********用户未登录，前往登录页面*************");
            response.sendRedirect("/admin");
            return false;
        }
        System.out.println("**********用户已登录，放行*************");
        return true;
    }
}
