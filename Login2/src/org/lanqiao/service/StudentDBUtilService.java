package org.lanqiao.service;

import java.util.List;

import org.lanqiao.dao.StudentUtilDao;
import org.lanqiao.entity.Student;

public class StudentDBUtilService {

		StudentUtilDao Dao = new StudentUtilDao();

		// 获取“数据总数”
		public int getTotalCount() {
			return Dao.getTotalCount();
		}

		public List<Student> getStudentsListForCurrentPage(int currentPage, int pageSize) {
			return Dao.getStudentListForCurrentPage(currentPage, pageSize);
		}


}
