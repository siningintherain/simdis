package com.alibaba.simdis.datasource;

import java.sql.Connection;

public interface SimDisConnector {

    Connection getConnection(String url, String username, String password);

    Connection getConnection(String url, String username, String password, int seconds);

}
