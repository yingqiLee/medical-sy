package com.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import com.entity.user;
import com.mapper.userMapper;
import com.util.MybatisUtil;

public class userDao {
	@Resource
	userMapper userMapper;
	
	public void findAll() {
		SqlSession session = MybatisUtil.openSqlSession();
		userMapper = session.getMapper(userMapper.class);
		List<user> users=new ArrayList<>();
		users = userMapper.selectAll();
		for(user u : users) {
		    System.out.println(u);
		}

	}

}
