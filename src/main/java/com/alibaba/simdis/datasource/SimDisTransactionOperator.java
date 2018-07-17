package com.alibaba.simdis.datasource;

/**
 * @author niancheng
 * @date 2018/7/17
 */
public interface SimDisTransactionOperator {
    void operate(SimDisSqlExecutor simDisSqlExecutor);
}
