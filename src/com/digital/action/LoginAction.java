package com.digital.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

public class LoginAction extends ActionSupport{
private String userName;
private String password;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

private String message;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

public String login() throws Exception {
	  Connection conn=null;
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;
	  String back=null;
	  try {
	   Class.forName("com.mysql.jdbc.Driver");
	   String user = "root";
	   String pass = "root123";
	   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CBDProject?characterEncoding=utf8&useConfigs=maxPerformance&useSSL=false",user,pass);
	   String sql="select * from user_info where userName='"+userName+"' and password='"+password+"'";
	   System.out.println(userName + password);
	   pstmt=conn.prepareStatement(sql);
	   rs=pstmt.executeQuery();
	   if (rs.next()) {
	    back="success";
	   }else{
	    setMessage("登录失败，请检查用户名和密码是否正确！");
	    back="input";
	   }   
	  } catch (Exception e) {
	   e.printStackTrace();
	  }finally{
	   try {
	    if (null!=rs) {
	     rs.close();
	    }
	    if (null!=pstmt) {
	     pstmt.close();
	    }
	    if (null!=conn) {
	     conn.close();
	    }
	   } catch (Exception e2) {
	    e2.printStackTrace();
	   }
	  } 
	  return back;
	 }

}

