package com.digital.action;

import com.digital.dao.impl.UserDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;
    private String message = "";

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

    private UserDAOImpl databaseAccessTool = new UserDAOImpl();

    public String login() {
        if (databaseAccessTool.loginInfoIsCorrect(username, password)) {
            setMessage("登陆成功！");
            return "success";
        }

        setMessage("用户名或密码错误。");
        return "input";
    }

    //=> 这里可能需要单独写一个RegisterAction类
    public String register() {
        if (!databaseAccessTool.hasUsername(username)) {
            //
            // 缺少数据库增加用户的代码
            // 需要实现一个User类
            //
            setMessage("注册成功");
            return "success";
        }

        setMessage("用户名重复");

        //=> return的状态可以修改
        return "input";
    }

}

