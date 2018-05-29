package org.lanqiao.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Student;

public class StudentDao {
	
	static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	static final String USER_NAMR = "scott";
	static final String PASSWORD = "Scott123456";
	
	//增加学生
	public boolean addStuden(Student stu){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//驱动
			Class.forName(DRIVER_NAME);
			//连接
			conn = DriverManager.getConnection(URL, USER_NAMR, PASSWORD);
			//操作语句
			String sql = "insert into student(studentNo,studentName,studentAge,gradeName) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getStudentNo());
			pstmt.setString(2, stu.getStudentName());
			pstmt.setInt(3, stu.getStudentAge());
			pstmt.setString(4, stu.getGradeName());
			
			int rs = pstmt.executeUpdate();
			if(rs>0){
				System.out.println("插入成功");
				return true;
			}else{
				System.out.println("插入失败");
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			//关闭
				try {
					if(pstmt != null){
					pstmt.close();
					}if(conn != null){
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			
		}
		return false;
	}
	//删除学生
	public boolean delectStudentByNo(int stuNo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER_NAMR, PASSWORD);
			String sql = "delete from student where studentNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuNo);
			int rs = pstmt.executeUpdate();
			if(rs>0){
				System.out.println("删除成功");
				return true;
			}else{
				System.out.println("删除失败");
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(pstmt!= null)
					pstmt.close();
					if(conn!= null)
						pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return false;
		
	}
	
	//修改学生信息
	public boolean updateStudent(Student stu,int stuNo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER_NAMR, PASSWORD);
			String sql = "update student set studentnNo = ?,studentName = ?,StudentAge = ?,gradeName=? where studentNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getStudentNo());
			pstmt.setString(2, stu.getStudentName());
			pstmt.setInt(3, stu.getStudentAge());
			pstmt.setString(4, stu.getGradeName());
			pstmt.setInt(5, stu.getStudentNo());
			
			int rs = pstmt.executeUpdate();
			if(rs>0){
				System.out.println("修改成功");
				return true;
			}else{
				System.out.println("修改失败");
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(pstmt!= null)
					pstmt.close();
					if(conn!= null)
						pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return false;
		
	}
	
	
	//学生查询
	public Student findStudentByNo(int stuno){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//驱动
		try {
			Class.forName(DRIVER_NAME);
			//连接
			conn = DriverManager.getConnection(URL, USER_NAMR, PASSWORD);
			//操作语句
			String sql = "select *  from student where studentNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				int sNo = rs.getInt(1);
				String sName = rs.getString(2);
				int sAge = rs.getInt(3);
				String gName = rs.getString(4);
				
				Student  stu = new Student();
				stu.setGradeName(gName);
				stu.setStudentAge(sAge);
				stu.setStudentName(sName);
				stu.setStudentNo(sNo);
				return stu;
			}
				
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(rs!=null){
					rs.close();
					}if(pstmt != null){
					pstmt.close();
					}if(conn != null){
					conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return null;
	}
	
	
	//判断学生是否存在
	public boolean isExistByNo(int stuNo){
		if(findStudentByNo(stuNo)!= null){
			System.out.println("学生已存在");
			return true;
		}else{
			System.out.println("学生不存在");
			return false;
		}
		
	}
	
	//查找全体学生
	public List<Student> findAllStudent(){
		List<Student> list = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DRIVER_NAME);
			//连接
			conn = DriverManager.getConnection(URL, USER_NAMR, PASSWORD);
			//操作语句
			String sql = "select * from student ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int stuNo = rs.getInt(1);
				String stuName = rs.getString(2);
				int stuAge = rs.getInt(3);
				String gName = rs.getString(4);
				Student stu = new Student(stuNo,stuName,stuAge,gName);
				list.add(stu);
			}
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
					try {
						if(rs != null) {
						rs.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						
						conn.close();
					}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		return null;
	}
	
	 
}
