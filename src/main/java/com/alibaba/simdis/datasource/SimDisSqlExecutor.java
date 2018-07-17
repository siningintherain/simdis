package com.alibaba.simdis.datasource;

import com.alibaba.simdis.datasource.exception.ConnectionCloseFailed;
import com.alibaba.simdis.datasource.exception.SqlExecuteFailed;
import com.alibaba.simdis.datasource.exception.SqlRollBackFailedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author niancheng
 * @date 2018/7/13
 */
public class SimDisSqlExecutor {

    /**
     * 数据源
     */
    private SimDisDataSourceFactory simDisDataSourceFactory;

    public SimDisSqlExecutor(SimDisDataSourceFactory simDisDataSourceFactory) {
        this.simDisDataSourceFactory = simDisDataSourceFactory;
    }

    /**
     * 更新sql
     *
     * @param sql
     * @param params
     */
    public void updateWithParams(String sql, Object... params) {
        Connection connection = simDisDataSourceFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setParams(preparedStatement, params);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SqlExecuteFailed(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new ConnectionCloseFailed(e);
            }
        }
    }

    /**
     * 更新sql
     *
     * @param sql
     */
    public void update(String sql) {
        updateWithParams(sql);
    }


    /**
     * 查询sql
     *
     * @param sql
     * @param tClass
     * @return
     */
    public <T> T queryWithParams(String sql, Class<T> tClass, Object... params) {
        Connection connection = simDisDataSourceFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setParams(preparedStatement, params);
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new SqlExecuteFailed(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new ConnectionCloseFailed(e);
            }
        }

    }

    public <T> T queryListWithParams(String sql, Class<T> tClass, Object... params) {

    }

    private void setParams(PreparedStatement preparedStatement, Object... params) throws SQLException {
        if (params != null) {
            int length = params.length;
            if (length != 0) {
                for (int i = 1; i <= length; i++) {
                    preparedStatement.setObject(i, params[i]);
                }
            }
        }
    }

    /**
     * 查询sql
     *
     * @param sql
     * @param tClass
     * @return
     */
    public <T> T query(String sql, Class<T> tClass) {
        return queryWithParams(sql, tClass);
    }


    /**
     * 事务型操作
     *
     * @param simDisTransactionOperator
     */
    public void transactionOperate(SimDisTransactionOperator simDisTransactionOperator) {
        Connection connection = simDisDataSourceFactory.getConnection();
        try {
            connection.setAutoCommit(false);
            simDisTransactionOperator.operate(this);
            connection.commit();
        } catch (Throwable e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new SqlRollBackFailedException(ex);
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new ConnectionCloseFailed(e);
            }
        }

    }

}
