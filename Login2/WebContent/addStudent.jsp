<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStudentServlet" method="post"  enctype=”multipart/form-data”>
	学生编号：<input type="text" name="stuNo"><br>
	姓名：<input type="text" name="stuName"><br>
	年龄：<input type="text" name="stuAge"><br>
	年级：<input type="text" name="gName"><br>
	<input type="submit" value="增加"><br>
	<%-- 上传文件   --%>
	上传文件：<input type = "file"  name = "sPicture">
	</form>
</body>
</html>