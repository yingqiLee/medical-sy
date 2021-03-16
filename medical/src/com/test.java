package com;

import org.apache.ibatis.session.SqlSession;

import com.Dao.userDao;
import com.mapper.userMapper;
import com.util.MybatisUtil;

public class test {
	public static void main(String[] args) {
		userDao d = new userDao();
		d.findAll();
	}
}
