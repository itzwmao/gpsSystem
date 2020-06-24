<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<title>QQ 注册</title>
<base href="<%=basePath%>">
<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/tools.js"></script>
<style type="text/css">
	tr>td:first-child {
		width:50px
	}
</style>
</head>
<body>
	<form id="form" action = "<%=basePath%>register.do" method="post">
		<table border="1" style="width:600px">
			<tr>
				<td>昵称：</td>
				<td><input type="text" name="name" value="${errorMap.name!=null?user.name:'' }" placeholder="请输入4-10位昵称">${errorMap.name==null?"":errorMap.name }</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="pwd" value="${errorMap.pwd!=null?user.pwd:'' }" placeholder="请输入6-16位字符">${errorMap.pwd==null?"":errorMap.pwd }</td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td><input type="text" name="phone" value="${errorMap.phone!=null?user.phone:'' }" placeholder="请输入正确的手机号码">${errorMap.phone==null?"":errorMap.phone }</td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="email" name="email" value="${errorMap.email!=null?user.email:'' }" placeholder="请输入正确的邮箱格式">${errorMap.email==null?"":errorMap.email }</td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="text" name="age" value="${errorMap.age!=null?user.age:'' }" placeholder="请输入一个正整数">${errorMap.age==null?"":errorMap.age }</td>
			</tr>
			<tr>
				<td><input id="reg" type="submit" name="注册"></td>
				<td><input type="reset" name="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>