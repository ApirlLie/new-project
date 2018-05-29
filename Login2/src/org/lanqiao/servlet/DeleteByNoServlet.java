package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.StudentService;

public class DeleteByNoServlet extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取stuNO
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		//通过service调用删除
		StudentService service = new StudentService();
		boolean flag = service.deleteStudentByNo(stuNo);
		if(flag){
			request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
		}
		System.out.println("删除失败");
	}

}
