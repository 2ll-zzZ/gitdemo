package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

@RequestMapping(value="/controller",method={RequestMethod.GET,RequestMethod.POST})
@RestController
public class controller {

	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/selectUser",method=RequestMethod.GET)
	@ResponseBody
	public List<User> selectUser(){
		return userservice.SelectUser();
	}
	
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public User insertUser(User user){
		return userservice.insertUser(user);
	}
	
	@RequestMapping(value="/selectbyname",method=RequestMethod.GET)
	@ResponseBody
	public List<User> selectbyname(String name){
		List<User> li = userservice.selectbyname(name);
		if(li.isEmpty()) {
			System.out.println("无此人数据");
			return null;
		}else {
			return li;
		}
		
	}
	
	@RequestMapping(value="/deletebyname",method=RequestMethod.GET)
	public String deletebyname(String name) {
		int ret =userservice.deletebyname(name);
		if(ret>=1) {
			return "删除成功";
		}else {
			return "删除失败";
		}
		
	}
	
	@RequestMapping(value="/updatebyname",method = RequestMethod.GET)
	public String updatebyname(String name,String number) {
		int ret =userservice.updatebyname(name,number);
		if(ret>=1) {
			return "更新成功";
		}else {
			return "更新失败";
		}
	}
}
