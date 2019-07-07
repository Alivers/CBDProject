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
}

