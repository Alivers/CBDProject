<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>电子商城-首页</title>
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
	<div class="sx mt10">
		<div class="sx_a">
			<span>所有分类 > 类型</span>
		</div>
		<table border="1">
			<s:iterator var="typeItem" value="#request.typeList">
				<tr>
					<td><s:property value="#typeItem.name" /></td>
					<td>品牌分类</td>
				</tr>
				<!-- 
				<p class="more fl"><img src="images/d006.jpg"/></p>  
				-->
			</s:iterator>
		</table>
	</div>
</body>
</html>
