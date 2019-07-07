<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->

</head>

<body>
	<div class="reg_c fl ah" >
	<s:form action="register" method="post" name="frm">
	    <table width="300" align="center" style="text-align:center; ">
		<s:textfield name="user.userName" label="登录名称" style="width:220px;"/>
		<s:password name="user.password" label="登录密码" style="width:220px;"/>
		<s:password name="repassword" label="确认密码" style="width:220px;"/>
		<s:textfield name="user.realName" label="真实姓名" style="width:220px;"/>
		<s:textfield name="user.address" label="通信地址" style="width:220px;"/>	
		<s:textfield name="user.email" label="电子邮件" style="width:220px;"/>
		<s:submit  value="注册" align="center" />
	    </table>
	</s:form>
    </div>

</body>
</html>
