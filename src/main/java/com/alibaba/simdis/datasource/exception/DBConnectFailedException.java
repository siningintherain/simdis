package com.alibaba.simdis.datasource.exception;

/**
 * @author niancheng
 * @date 2018/7/12
 */
public class DBConnectFailedException extends RuntimeException {
    public DBConnectFailedException() {
    }

    public DBConnectFailedException(String message) {
        super(message);
    }

    public DBConnectFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBConnectFailedException(Throwable cause) {
        super(cause);
    }

    public DBConnectFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
