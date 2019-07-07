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

<title>My JSP 'userinfo.jsp' starting page</title>

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
	<div class="reg_b fl">用户详细信息</div>
	<div class="reg_c fl ah">
		<table width="350" border="0" align="center">
			<tr>
				<td width="100" height="35" align="right" valign="middle">
					用户名称：</td>
				<td width="250" align="left" valign="middle">
				<s:property value="user.userName" /></td>
			</tr>
			<!-- TODO: 其他字段的相似代码 -->
			
			
		</table>
	</div>
</body>
</html>
