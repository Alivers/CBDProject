package com.digital.dao.impl;

import com.digital.dao.BaseDAO;
import com.digital.dao.UserDAO;
import com.digital.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// dao（Data Access Object）层，包含了user_info表单的增删改查等功能。
//=> 还需要增加很多方法去完善。
public class UserDAOImpl implements UserDAO {
    static private String listName = "user_info";
    private BaseDAO database = new BaseDAO();

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
            database.closeAll(connection, statement, resultSet);
        }

        return result;
    }

    @Override
    public boolean addUser(User user) {
        String sql = String.format("insert into %s values " +
                        "(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, '%s')",
                listName,
                0,
                user.getUserName(),
                user.getPassword(),
                "use",
                "use",
                "use",
                "use",
                "use",
                "use",
                "use",
                0,
                "2012-4-4"
                /*user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRealName(),
                user.getSex(),
                user.getAddress(),
                user.getQuestion(),
                user.getAnswer(),
                user.getEmail(),
                user.getFavorite(),
                user.getScore(),
                user.getRegDate().toString()*/
        );
        if (hasUsername(user.getUserName()))
            return false;
        executeSqlStatement(sql);
        return true;
    }

    private void executeSqlStatement(String sqlStatement) {
        Connection connection = null;
        PreparedStatement statement = null;

        boolean result;

        try {
            connection = database.getConnection();
            statement = connection.prepareStatement(sqlStatement);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.closeAll(connection, statement, null);
        }
    }

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
