<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<title>用户登录</title>
<base href="<%=basePath%>">
<style type="text/css">
	tr>td:first-child {
		width:50px
	}
</style>
</head>
<body>
	<form id="form" action="<%=basePath%>login.do" method="post">
		<table border="1" style="width:600px">
			<tr>
				<td>昵称：</td>
				<td><input type="text" name="name" placeholder="请输入4-10位昵称"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="pwd" placeholder="请输入6-16位字符"></td>
			</tr>
			<tr>
				<td><input id="reg" type="submit" name="登陆"></td>
				<td><input type="reset" name="重置"><a href="<%=basePath%>pages/front/register.jsp">注册</a></td>
			</tr>
		</table>
	</form>
</body>
</html>