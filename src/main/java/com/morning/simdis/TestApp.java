package com.morning.simdis;

import com.morning.simdis.utils.SimpleJDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * com.morning.simdis.TestApp
 *
 * @author Niancheng
 * @date 2018/11/9
 */
public class TestApp {

    static{
        try {
            SimpleJDBCUtils.init("jdbc:mysql://127.0.0.1:3306/test","root","12345678");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJDBC() throws SQLException {
        Connection connection = SimpleJDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("show tables;");
        ResultSet resultSet = preparedStatement.executeQuery();
    }
}
