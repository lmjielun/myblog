package com.li.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice // 顾名思义，controller切面，这样只要加有controller注解的类，都会被该类先拦截
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    /**
     * 异常处理
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class}) // 加入该注解，说名该方法是处理异常的
    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {

        logger.error("Request URL : {} , Exception : {}", request.getRequestURL(), e);

        // 如果携带有状态码的异常，不拦截，比如类上加有@ResponseStatus(HttpStatus.NOT_FOUND)注解的，指定了状态码
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            // 直接抛出即可，不再往下继续走
            throw e;
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("url", request.getRequestURL());
        mav.addObject("exception", e);
        mav.setViewName("error/error"); // 返回到error下的error.html

        return mav;
    }
}
