package com.alibaba.simdis.datasource.exception;

/**
 * @author niancheng
 * @date 2018/7/17
 */
public class SqlRollBackFailedException extends RuntimeException{
    public SqlRollBackFailedException() {
    }

    public SqlRollBackFailedException(String message) {
        super(message);
    }

    public SqlRollBackFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlRollBackFailedException(Throwable cause) {
        super(cause);
    }

    public SqlRollBackFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
