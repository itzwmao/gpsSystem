<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<title>new jsp</title>
<base href="<%=basePath%>">
</head>
<body>
	<h1>视图解析器</h1>
	<form action="<%=basePath%>uploadFileDemo.do" method="post" enctype="multipart/form-data">
		<table border="1" style="width:400px">
			<tr>
				<td>文件：</td>
				<td><input type="file" name="bigImage"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="上传"></td>
			</tr>
		</table>
	</form>
	<form action="<%=basePath%>uploadMultiFileDemo.do" method="post" enctype="multipart/form-data">
		<table border="1" style="width:400px">
			<tr>
				<td>文件：</td>
				<td><input type="file" name="bigImages" multiple="multiple"></td>
			</tr>
			<tr>
				<td>文件：</td>
				<td><input type="file" name="bigImages1" multiple="multiple"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="多文件上传"></td>
			</tr>
		</table>
	</form>
</body>
</html>