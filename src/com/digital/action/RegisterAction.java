package com.digital.action;

import com.digital.dao.UserDAO;
import com.digital.dao.impl.UserDAOImpl;
import com.digital.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
    private User user;
    private String rePassword;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

//    @Override
//    public void validate() {
//        if (user.getUsername().length() == 0)
//            addFieldError("username", "用户名不能为空");
//        if (user.getPassword().length() == 0)
//            addFieldError("password", "密码不能为空");
//        if (!(user.getPassword() == rePassword))
//            addFieldError("repassword", "确认密码与登陆密码不一致");
//        // ...
//    }

    public String execute() throws Exception {
//        validate();
        UserDAO ud = new UserDAOImpl();
        if (ud.addUser(user))
            return "success";
        else
            return "input";
    }
}
