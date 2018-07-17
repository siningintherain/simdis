package com.alibaba.simdis.datasource;

import com.alibaba.simdis.datasource.exception.DBConnectFailedException;
import com.alibaba.simdis.datasource.exception.JdbcDriverNotFoundException;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * jdbc连接器
 *
 * @author niancheng
 * @date 2018/7/12
 */
@Component
public class SimDisDataSourceFactory {

    private static final ThreadLocal<Connection> LOCAL_CONNECTION = new ThreadLocal<>();

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SimDisDataSourceFactory(String driverClassName) {
        try {
            // 加载jdbc驱动
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new JdbcDriverNotFoundException(e);
        }
    }

    /**
     * 获取连接
     */
    public Connection getConnection() {
        Connection connection = LOCAL_CONNECTION.get();
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                LOCAL_CONNECTION.set(connection);
            } catch (SQLException e) {
                throw new DBConnectFailedException(e);
            }
        }
        return connection;
    }


}
