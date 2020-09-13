package com.li.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  过滤器控制
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     *  将你的拦截器进行注册，配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器，设置拦截admin下所有，设置不拦截admin 以及 admin/lgoin
        // 如果你拦截了admin/login 那么将会连登录页面都进不来
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin") // 不拦截admin
                .excludePathPatterns("/admin/login"); //不拦截login
    }
}
