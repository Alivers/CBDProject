<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录页面</title>

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
	<div>
		<form name="loginform" action="loginAction" method="post">
			<table>
				<tr>
					<td><font color="red">${message} </font></td>
				</tr>
				<tr>
					<td>用户名：</td>
					<td><input name="username" type="text" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input name="password" type="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录"></td>
					<td><a href="register.jsp">注册页面</a></td>
				</tr>

				<tr>
			</table>
		</form>
	</div>
</body>
</html>