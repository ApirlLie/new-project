package org.lanqiao.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		User user =new User();
		user.setUserName(uname);
		user.setPassWord(pwd);
//		
		UserService service = new UserService();
		//通过username 去查找user对象
		User user2 = service.findUserByUsername(uname);
		if(user2 != null) {
			if(user2.getPassWord().equals(pwd)) {
				//System.out.println("user2.getPassWord()");
				//登录成功
				//显示全部的学生信息
				request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
			}
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
