package com.digital.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
    static final String driverName = "com.mysql.jdbc.Driver";

    private final String databaseName = "CBDProject";
    private final String username = "root";
    private final String password = "root123";

    // Database(databaseName, username, password) { ... }

    public Connection getConnection() {
        Connection connection = null; // 端口
        final String url = String.format(
                "jdbc:mysql://localhost:3306/%s?characterEncoding=utf8&useConfigs=maxPerformance&useSSL=false",
                databaseName
        );

        try {
            // 装载驱动
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    // 若不需要3个都close，相应的参数传入null即可。
    public void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) connection.close();
            if (preparedStatement != null) preparedStatement.close();
            if (resultSet != null) resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
