package com.alibaba.simdis.datasource.exception;

/**
 * @author niancheng
 * @date 2018/7/17
 */
public class SqlExecuteFailed extends RuntimeException {
    public SqlExecuteFailed() {
    }

    public SqlExecuteFailed(String message) {
        super(message);
    }

    public SqlExecuteFailed(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlExecuteFailed(Throwable cause) {
        super(cause);
    }

    public SqlExecuteFailed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
