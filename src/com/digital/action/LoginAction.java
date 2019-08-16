package com.digital.action;

import java.util.Map;

import com.digital.dao.impl.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String userName;
    private String password;
    private String message = "";


    public String getPassword() {
        return password;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
        if (databaseAccessTool.loginInfoIsCorrect(userName, password)) {
            setMessage("登陆成功！");
            /*
            Map<String, Object> session=null;		  
            session=ActionContext.getContext().getSession();
            session.put("CURRENT_USER",userName);
            // 获取当前时间
            long currentTime=System.currentTimeMillis();
            //获取开始时间
            Long startTime=(Long)session.get("startTime");   
            if (startTime==null) {	//第一次访问
                startTime=currentTime;
                session.put("startTime", startTime);
            }
            // 以分钟秒计算访问的时间
            long usedTime=(currentTime-startTime)/1000/60; 
            if (usedTime>60) {
               this.setMessage(userName+"，您已经访问："+usedTime+" 分钟，请注意休息！");
            }else if (usedTime==0) {
              this.setMessage(userName+"您刚开始访问系统"+usedTime+" 分钟，祝您愉快！");
            }else{
            	this.setMessage(userName+"，您已经访问系统："+usedTime+"分钟。");
            }
            */

            return "success";
        }

        setMessage("用户名或密码错误。");
        return "input";
    }
}

