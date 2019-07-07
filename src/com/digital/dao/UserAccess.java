package com.digital.dao;

import com.digital.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// dao（Data Access Object）层，包含了user_info表单的增删改查等功能。
//=> 还需要增加很多方法去完善。
public class UserAccess {
    static private String listName = "user_info";
    private Database database = new Database();

    // 根据sql语句进行查询，查到了返回true，否则返回false。
    private boolean getQueryResult(String sqlQueryStatement) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // 不初始化，之后的语句是complete的，包含了result所有可能的情况。
        boolean result;

        try {
            connection = database.getConnection();
            statement = connection.prepareStatement(sqlQueryStatement);
            resultSet = statement.executeQuery();
            // 非空表示查到了，则返回true。
            // 必须要在close之前进行赋值，否则会抛出异常。
            result = resultSet.next();
        } catch (Exception e) {
            // 抛出异常，返回结果为false。
            result = false;
            e.printStackTrace();
        } finally {
            database.close(connection, statement, resultSet);
        }

        return result;
    }

    //
    //=> Unimplemented
    // private void/*boolean*/ executeSqlStatement(String sqlStatement) {
    //     // 建立连接
    //     // 执行语句...
    //     // 关闭连接
    // }
    //

    //
    //=> Unimplemented
    // public void/*boolean*/ insertUser(User user) {
    //     String sql = /* sql插入语句 */
    //     executeSqlStatement(sql);
    // }
    //

    public boolean loginInfoIsCorrect(String username, String password) {
        String sql = String.format("select * from %s where username='%s' and password='%s'",
                listName, username, password);
        return getQueryResult(sql);
    }

    public boolean hasUsername(String username) {
        String sql = String.format("select * from %s where username='%s'", listName, username);
        return getQueryResult(sql);
    }
}
