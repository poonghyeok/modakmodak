package com.modak.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SqlSession session;
	
	private final String namespace = "userSQL.";
	
	@Override
	public int count(){
		System.out.print("UserDaoImpl..test..count..");
		return session.selectOne(namespace+"userCount");
	}
}
