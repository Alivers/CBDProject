<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import=" java.text.SimpleDateFormat"%>
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

<title>上海军火交易市场</title>
<sx:head />  <!-- Ajex要用 -->
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
<% 
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeString = sdf.format(date);
            long currentTime = System.currentTimeMillis(); 
            Long stratTime = (Long) session.getAttribute("currentTime");
            if (stratTime == null) {
                session.setAttribute("currentTime", currentTime);
            } 
            else {
                long used = (currentTime - stratTime) / 1000 / 60;
                session.setAttribute("used", used);
                boolean flag = false;
                if (used > 60) {
                    flag = true;
                }
                session.setAttribute("flag", flag);
            } 
        %>
        	现在时间是：<%=timeString %>
        <s:if test="#session.flag==true">
         	你已访问时间：<s:property value="#session.used" default="0" />分钟
         </s:if>
        <s:else>
         	你已访问时间：<s:property value="#session.used" default="0" />分钟
         </s:else>

	<div class="itop_body">
      <div class="itop_left fl">欢迎光临上海军火交易市场！  
      </div>
	<div class="itop_right fl">
	  <div id="header">
	  		<!-- 
          <sx:div id="tsdiv" updateFreq="2000" href="Login_loginAction">
          </sx:div> -->
        </div>
        <!-- 用于显示请求 -->
	  <font color="red">${message}</font>
	  <!-- 省略其他代码 -->
      </div>
    </div>

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
