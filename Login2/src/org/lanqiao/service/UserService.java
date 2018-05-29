package org.lanqiao.service;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;

public class UserService {
		//查找用户
	public User findUserByUsername(String username){
		UserDao dao =new UserDao();
		return dao.findUserByUsername(username);
	}
}
