package com.alibaba.simdis.datasource;

import com.alibaba.simdis.datasource.exception.DBConnectFailedException;
import com.alibaba.simdis.datasource.exception.JdbcDriverNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * jdbc连接器
 *
 * @author niancheng
 * @date 2018/7/12
 */
public class SimpleJdbcConnector implements SimDisConnector {

    public SimpleJdbcConnector(String driverClassName) {
        try {
            // 加载jdbc驱动
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new JdbcDriverNotFoundException(e);
        }
    }

    @Override
    public Connection getConnection(String url, String username, String password) {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new DBConnectFailedException(e);
        }
    }

    @Override
    public Connection getConnection(String url, String username, String password, int seconds) {
        DriverManager.setLoginTimeout(seconds);
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new DBConnectFailedException(e);
        }
    }

}
