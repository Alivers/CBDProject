<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!-- Ajax用 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
<base href="<%=basePath%>">

<title>树形目录</title>
<sx:head />  <!-- 这个一定要加！！！！！！ -->
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
	<!-- <h3>使用sx:tree和sx:treenode标签生成静态树</h3> -->
	<sx:tree label="军火列表" id="booklist" showRootGrid="true" showGrid="true"
		treeSelectedTopic="treeSelected">
		<sx:treenode label="俄国" id="tsinghua">
			<sx:treenode label="AK47" id="ssh" />
		</sx:treenode>
		<sx:treenode label="美国" id="phei">
			<sx:treenode label="浪潮4" id="struts2" />
		</sx:treenode>
		<sx:treenode label="中国" id="ptpress">
			<sx:treenode label="东风23" id="jsp" />
			<sx:treenode label="大疆军用" id="jsp" />
		</sx:treenode>
	</sx:tree>
</body>
</html>
