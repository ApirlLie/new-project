package org.lanqiao.entity;

public class Student {
	//学号
	private int studentNo;
	//姓名
	private String studentName;
	//年龄
	private int studentAge;
	//年级
	private String gradeName;
	
	public Student(int studentNo,String studentName,int studentAge,String gradeName){
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.gradeName = gradeName;
		this.studentAge = studentAge;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
	
}
