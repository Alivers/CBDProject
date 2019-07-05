package com.digital.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
private String userName;
private String passWord;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}

public String login() throws Exception{
	String back="success";
	return back;
}

}
