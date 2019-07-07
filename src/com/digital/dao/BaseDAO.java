package com.digital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDAO {
    static final String driverName = "com.mysql.jdbc.Driver";

    private final String databaseName = "CBDProject";
    private final String username = "root";
    private final String password = "root123";

    // BaseDAO(databaseName, username, password) { ... }

    public Connection getConnection() {
        Connection conn = null; // 端口
        final String url = String.format(
                "jdbc:mysql://localhost:3306/%s?characterEncoding=utf8&useConfigs=maxPerformance&useSSL=false",
                databaseName
        );

        try {
            // 装载驱动
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    // 若不需要3个都close，相应的参数传入null即可。
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (conn != null) conn.close();
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
