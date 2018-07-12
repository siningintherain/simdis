package com.alibaba.simdis.datasource.exception;

/**
 * @author niancheng
 * @date 2018/7/12
 */
public class JdbcDriverNotFoundException extends RuntimeException {
    public JdbcDriverNotFoundException() {
    }

    public JdbcDriverNotFoundException(String message) {
        super(message);
    }

    public JdbcDriverNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JdbcDriverNotFoundException(Throwable cause) {
        super(cause);
    }

    public JdbcDriverNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
