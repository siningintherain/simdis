package com.morning.simdis.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * com.morning.simdis.utils.SimpleJDBCUtils
 *
 * @author Niancheng
 * @date 2018/11/9
 */
public class SimpleJDBCUtils {

    private static String JDBC_URL;

    private static String PASSWORD;

    private static String USERNAME;

    public static void init(String url, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        JDBC_URL = url;
        USERNAME = username;
        PASSWORD = password;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }


}
