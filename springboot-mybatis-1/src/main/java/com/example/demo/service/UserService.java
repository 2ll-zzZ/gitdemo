package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper usermapper;
	
	public List<User> SelectUser(){
		return usermapper.selectUser();
		
	}
	
	public User insertUser(User user) {
		usermapper.insertUser(user);
		return user;
	}
	
	public List<User> selectbyname(String name){
		return usermapper.selectbyname(name);
	}
	
	public int deletebyname(String name) {
		return usermapper.deletebyname(name);
	}
	
	public int updatebyname(String name,String number) {
		return usermapper.updatebyname(name,number);
	}
 }
