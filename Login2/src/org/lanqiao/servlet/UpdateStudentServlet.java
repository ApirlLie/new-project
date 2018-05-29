package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Student;
import org.lanqiao.service.StudentService;


public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//获取数据
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		Student stu = request.getParameter("");
		//通过第二层调用
		StudentService service = new StudentService();
		service.updateStudentByNo(stu, stuNo);
		
		
		
	}

}
