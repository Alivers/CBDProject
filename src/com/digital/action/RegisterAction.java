package com.digital.action;

import com.digital.dao.UserDAO;
import com.digital.dao.impl.UserDAOImpl;
import com.digital.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
    private User user;
    private String rePassword;

    private String message = "";

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String execute() throws Exception {
        UserDAO ud = new UserDAOImpl();
        if (ud.addUser(user)) {
            setMessage("注册成功");
            return "success";
        }
        setMessage("用户名重复，注册失败");
        return "input";
    }
//    public void validateRegister(){
//        if(user.getUserName()==null || user.getUserName().equals("")){
//    	//this.addFieldError("user.UserName","用户名不能为空");
//           this.addFieldError("user.userName",getText("userName.null"));
//        }
//        if(user.getUserName()==null || user.getUserName().equals("")){
//        	//this.addFieldError("user.UserName","用户名不能为空");
//               this.addFieldError("user.userName",getText("userName.null"));
//        }
//      }

}
