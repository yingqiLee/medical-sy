package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.entity.user;

public interface userMapper {
	public List<user> selectAll();
	public void insertUser(user user);
	public user findByUserName(String userName);
	public void updateUser(@Param("userName")String userName,@Param("id")int id);

}
