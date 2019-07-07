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

<title><s:text name="register.page"></s:text></title>

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
	<div class="reg_b fl">
		<s:text name="register.title" />
	</div>
	<div class="reg_c fl ah">
		<s:form action="registerAction" method="post" name="registerform">
			<!-- registerAction和struts.xml中的一样 -->
			<tr>
				<td><font color="red">${message} </font></td>
			</tr>
			<table width="300" align="center" style="text-align:center; ">
				<s:textfield name="user.userName" key="userName" style="width:220px;" />
				<s:password name="user.password" key="password" style="width:220px;" />
				<s:password name="rePassword" key="repassword" style="width:220px;" />
				<s:textfield name="user.realName" key="realName" style="width:220px;" />
				<s:textfield name="user.address" key="address" style="width:220px;" />
				<s:textfield name="user.email" key="email" style="width:220px;" />
				<s:submit value="%{getText('submit')}" align="center" />
			</table>
		</s:form>
	</div>

</body>
</html>
