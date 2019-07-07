package com.digital.action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // 数据库名称、密码等信息
    private static class SqlInfo {
        static final String driverName = "com.mysql.jdbc.Driver";
        static final String url = "jdbc:mysql://localhost:3306/CBDProject?" +
                "characterEncoding=utf8&useConfigs=maxPerformance&useSSL=false";
        static final String username = "root";
        static final String password = "root123";
    }

    public String login() throws Exception {
        Connection connection = null; // 端口
        PreparedStatement preparedStatement = null; // sql语句模型
        ResultSet resultSet = null; // 查询结果集合
        String result = null; // 返回的查询结果

        try {
            // 装载驱动
            Class.forName(SqlInfo.driverName);

            // 建立连接
            connection = DriverManager.getConnection(SqlInfo.url, SqlInfo.username, SqlInfo.password);

            // sql语句
            String sql = "select * from user_info where username='" + username + "' and password='" + password + "'";

            // 执行语句
            preparedStatement = connection.prepareStatement(sql);

            // 查询结果
            resultSet = preparedStatement.executeQuery();

            // 非空代表查询成功
            if (resultSet.next()) {
                result = "success";
            } else {
                setMessage("登录失败，请检查用户名和密码是否正确！");
                result = "input";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
                if (null != preparedStatement) {
                    preparedStatement.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // 注册功能：duplicate code，需要后续修改
    public String register() throws Exception {
        Connection connection = null; // 端口
        PreparedStatement preparedStatement = null; // sql语句模型
        ResultSet resultSet = null; // 查询结果集合
        String result = null; // 返回的查询结果

        try {
            // 装载驱动
            Class.forName(SqlInfo.driverName);

            // 建立连接
            connection = DriverManager.getConnection(SqlInfo.url, SqlInfo.username, SqlInfo.password);

            // 查询是否有重复的用户名
            String sqlQuery = "select * from user_info where username='" + username + "'";
            preparedStatement = connection.prepareStatement(sqlQuery);

            // 查询结果
            resultSet = preparedStatement.executeQuery();
            // 空代表用户名没有重复
            if (!resultSet.next()) {
                result = "success";
            } else {
                setMessage("用户名重复，注册失败！");
                result = "input";
                return result;
            }

            // sql插入语句
            String sqlInsert = "insert into user_info values (" + 100 + ", '" + username + "'" + ", " + "'" + password + "'" +
                    ", '', '', '', '', '', '', '', " + 0 + ", '1999-6-30'" + ")";
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.execute();

            // 显示注册成功信息
            setMessage("注册成功！");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
                if (null != preparedStatement) {
                    preparedStatement.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}

