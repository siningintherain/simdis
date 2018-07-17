package com.alibaba.simdis.datasource.exception;

/**
 * @author niancheng
 * @date 2018/7/17
 */
public class ConnectionCloseFailed extends RuntimeException {
    public ConnectionCloseFailed() {
    }

    public ConnectionCloseFailed(String message) {
        super(message);
    }

    public ConnectionCloseFailed(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionCloseFailed(Throwable cause) {
        super(cause);
    }

    public ConnectionCloseFailed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
