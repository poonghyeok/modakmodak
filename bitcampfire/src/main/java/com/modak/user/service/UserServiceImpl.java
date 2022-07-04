package com.modak.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modak.user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;
	
	@Override
	public int getCount() {
		System.out.print("userServiceImpl...test..getCount..");
		return userDAO.count();
	}
}
