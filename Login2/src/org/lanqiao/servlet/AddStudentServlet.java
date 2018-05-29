package org.lanqiao.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.entity.Student;
import org.lanqiao.service.StudentService;

public class AddStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//使用out.println()之前要使用setContentType()方法编码
		response.setContentType("text/html;charset=utf-8");
		/*
		PrintWriter out = response.getWriter();
		//上传的文件名
		String uploadFileName = "";
		//表单字段元素的name属性值
		String fileName = "";
		//请求信息request中的内容是否是multipart类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart){
			//通过工厂模式 建立FileItemFactory对象
			FileItemFactory factory = new DiskFileItemFactory();
			//通过FileItemFactory对象 ，产生ServletFileUpload对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				//保存学生信息的属性值
				int studentNo = -1;
				String StudentName = null;
				int StudnetAge = -1;
				String gradeName = null;
				//解析form表单中的所有字段元素
				List<FileItem> items  = upload.parseRequest(request);
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		String stuName = request.getParameter("stuName");
		int stuAge = Integer.parseInt(request.getParameter("stuAge"));
		String gName = request.getParameter("gName");
		
		//将信息封装
		Student stu = new Student();
		stu.setGradeName(gName);
		stu.setStudentAge(stuAge);
		stu.setStudentName(stuName);
		stu.setStudentNo(stuNo);
		
		//增加
		//业务逻辑层
		StudentService service = new StudentService();
		boolean flag = service.addStudent(stu);
		if(flag){
			System.out.println("增加成功");
			//如果增加成功 放入request5标识符stu
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else {
			System.out.println("增加失败");
			response.sendRedirect("addStudent.jsp");
		}
		
		
	}

}
