package org.lanqiao.util;

import java.util.List;

import org.lanqiao.entity.Student;

// 省略import
public class Page
{
	// 总页数
	private int totalPage;
	// 数据总数;即一共有都少条数据，需要显示）
	private int totalCount;
	// 页面大小;即每页显示几条数据
	private int pageSize;
	// 当前页的页码
	private int currentPage;
	// 实体类集合;如List<Student> students，用来保存当前页面中全部学生的信息
	private List<Student> students;

	// 不存在“总页数”的setter方法，因为总页数是由“数据总数”和“页面大小”计算而来的
	// 当“页面大小”和“数据总数”被赋值之后，可以自动计算出“总页数”
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
         //自动计算出“总页数”
		totalPage = this.totalCount % pageSize == 0 ? 
(this.totalCount / pageSize) : this.totalCount / pageSize + 1;
	}
	//set  get方法

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}
	

}
