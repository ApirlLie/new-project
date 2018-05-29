<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除学生</title>
</head>
<body>
		<form action="deleteByNoServlet" method="post"  enctype=”multipart/form-data”>
	学生编号：<input type="text" name="stuNo"><br>
	<input type="submit" value="删除"><br>

</body>
</html>