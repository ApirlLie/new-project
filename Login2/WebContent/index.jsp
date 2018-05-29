<%@page import="org.lanqiao.util.Page"%>
<%@page import="org.lanqiao.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 …
  <table border="1" >
   <tr>
    <th>学号</th>
    <th>姓名</th>
    <th>年龄</th>
    <th>操作</th>
   </tr>
   
   <%
    //获取带数据的分页帮助类对象
   Page pages=(Page)request.getAttribute("pages");
    //总页数
           int totalpages=pages.getTotalPage();  
           //当前页的页码
           int pageIndex=pages.getCurrentPage(); 
       	int pageSize = pages.getPageSize();
          //获取当前页中的学生数据集合
    List<Student> students =pages.getStudents();
    if(students != null)
    {
     
    	for(int i =0;i<students.size();i++){
    		out.print("<tr>");
    		out.print("<td>"+students.get(i).getStudentNo()+"</td>");
    		out.print("<td>"+students.get(i).getStudentName()+"</td>");
    		out.print("<td>"+students.get(i).getStudentAge()+"</td>");
    		out.print("<td>"+students.get(i).getGradeName()+"</td>");
    		out.print("<td><a href='deleteByNoServlet?stuNo="+students.get(i).getStudentNo()+"'>删除</a>/<a href='UpdateStudentServlet'?stuNo="+students.get(i).getStudentNo()+"'>修改</a></td>");
    		out.print("</tr>");
    	}
    }
   %>
  </table>
    当前页数：[<%=pageIndex%>/<%=totalpages%>]
    <%
     //只要不是首页，则都可以点击“首页”和“上一页”
        if(pageIndex > 1)
        {  
    %>   
        <%-- 通过用户点击超链接，将页码传递给Servlet --%>
        <a href="QueryAllStudentsServlet?currentPage=1&&pageSize=<%=pageSize%>">首页
</a>&nbsp;
        <a href="QueryAllStudentsServlet?currentPage
=<%= pageIndex -1%>&&pageSize=<%=pageSize%>">上一页
</a>
   <%   }
    //只要不是末页，则都可以点击“下一步”和“末页”
         if(pageIndex < totalpages)
         { 
   %>
       <%-- 通过用户点击超链接，将页码传递给Servlet --%>
       <a href="QueryAllStudentsServlet?currentPage=<%= pageIndex +1%>&&pageSize=<%=pageSize%>">下一页
	</a>
       <a href="QueryAllStudentsServlet?currentPage=<%=totalpages%>&&pageSize=<%=pageSize%>">末页
</a> 
   <% 
      }
      %>   
  <a href="addStudent.jsp">增加</a>
</body>
</html>