package com.li.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
     *  定义切面，以及哪个类使用切面
     */
    @Pointcut("execution(* com.li.web.*.*(..))")
    public void log(){}

    @Before("log()") // 方法执行前
    public void doBefore(JoinPoint joinPoint){
        // 先获取到request
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取类名 获取方法名
        String classMethod =
                joinPoint.getSignature().getDeclaringTypeName() + "." +
                        joinPoint.getSignature().getName();
        // 创建内部类，进行封装
        RequestLog requestLog = new RequestLog(
                request.getRequestURL().toString(),
                request.getRemoteAddr(),
                classMethod,
                joinPoint.getArgs()
        );
        // 输出
        logger.info("请求信息： {}",requestLog);
    }

    @After("log()") // 方法执行后
    public void doAfter() {
        //logger.info("---------- doAfter 2 ----------");
    }

    // 方法返回
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAtfertRturning(Object result) {
        logger.info("Return ------ {}",result );
    }

    // 内部类
    private class RequestLog{
        // 属性参数
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        /**
         * 全参构造
         * @param url
         * @param ip
         * @param classMethod
         * @param args
         */
        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        /**
         * tostring
         * @return
         */
        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }


}
