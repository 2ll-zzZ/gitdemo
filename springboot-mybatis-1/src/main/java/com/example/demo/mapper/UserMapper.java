package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {

	public List<User> selectUser();
	
	public int insertUser(User user);
	
	public List<User> selectbyname(String name);
	
	public int deletebyname(String name);
	
	public int updatebyname(String name,String number);
}
