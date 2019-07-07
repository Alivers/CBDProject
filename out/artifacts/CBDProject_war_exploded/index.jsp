<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
		<div class="sx_a"><span>所有分类 > 类型</span></div>
		  <s:iterator id="typeItem" value="#request.typeList">
			<div class="sx_b">		
				<p class="tit fl">${typeItem.name }</p>
				<p class="con fl">
					&nbsp;品牌分类 		<!-- 后续完善 -->
				</p>
				<!-- 
				<p class="more fl"><img src="images/d006.jpg"/></p>  
				-->
			
			</div>
		  </s:iterator>
	</div>
</body>
</html>
