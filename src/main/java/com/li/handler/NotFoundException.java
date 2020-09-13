package com.li.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 资源找不到异常类
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // not_found 找不到
public class NotFoundException extends RuntimeException {
    /**
     * 加入构造方法
     */

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
