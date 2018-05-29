package org.lanqiao.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Student;
import org.lanqiao.util.DBUtil;

public class StudentUtilDao {
	//获取数据总数	
	public int getTotalCount(){
		
		String sql = "select count(*) from Student";
		
		return DBUtil.getTotalCount(sql);
		
	}
	//分页
	public List<Student> getStudentListForCurrentPage(int pagesize,int currentpage){
		String sql = "select * from " + "(" + "select rownum r,t.* "
					+ "from (select s.* from student s  order by studentNo asc ) t " 
					+ "where rownum<= ? )" + "where r>= ?";
		Object [] os = {
				currentpage * pagesize,(currentpage - 1)*pagesize+1
		};
		System.out.println("StudentUtilDao:pageSize---"+pagesize);
		// 获取当前页的学生集合
		  ResultSet rs = DBUtil.executeQuery(sql, os);
		  List<Student> students = new ArrayList<Student>();
		  try
		  {
		   while (rs.next())
		   {
			
		    int sNo = rs.getInt("studentNo");
		    String sName = rs.getString("studentName");
		    int sAge = rs.getInt("studentAge");
		    String gName = rs.getString("gradeName");
		    // 将查到的学生信息，封装到stu对象中
		    Student stu = new Student(sNo, sName, sAge, gName);
		    // 将封装好的stu对象，存放到List集合中
		    students.add(stu);
		   }
		  }
		  catch (Exception e)
		  {
		   e.printStackTrace();
		  }
		  finally
		  {
		   DBUtil.closeAll(rs, DBUtil.getPstmt(sql, os), DBUtil. getConnection ());
		  }
		  System.out.println(students.toString());
		  return students;
		
	}
}
