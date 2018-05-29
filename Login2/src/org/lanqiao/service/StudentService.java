package org.lanqiao.service;
import java.util.List;

import org.lanqiao.dao.StudentDao;
import org.lanqiao.entity.Student;

public class StudentService {
	StudentDao dao = new StudentDao();
		//业务逻辑层
		//增加
	public boolean addStudent(Student stu){
		int stuNo = stu.getStudentNo();
		if(dao.isExistByNo(stuNo)){
			System.out.println("学生已存在");
			return false;
		}else{
			System.out.println("NO STUDENT!");
			return	dao.addStuden(stu);
		}
	}
	//删除
	public boolean deleteStudentByNo(int stuNo){
		if(!dao.isExistByNo(stuNo)){
			System.out.println("学生不存在");
			return false;
		}else{
			return	dao.delectStudentByNo(stuNo);
		}
	}
	
	//修改
	public boolean updateStudentByNo(Student stu,int stuNo){
		if(!dao.isExistByNo(stuNo)){
			System.out.println("学生不存在");
			return false;
		}else{
			return	dao.updateStudent(stu, stuNo);
		}
	}
	//查询全部学生
	public List<Student> queryAllStudents(){
		
		return dao.findAllStudent();
	}
	public Student getStudentByid(int i) {
		// TODO Auto-generated method stub
		return dao.findStudentByNo(i);
	}

	
}
