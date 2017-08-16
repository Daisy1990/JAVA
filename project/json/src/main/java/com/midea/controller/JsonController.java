package com.midea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.midea.entity.User;

@Controller
public class JsonController {
	@RequestMapping("/json1.do")//匹配请求
	//如果我们想要把user对象 以json对象格式返回的话 要在loadUser()上加上@ResponseBody
	@ResponseBody //调用jackson
	public User loadUser(){
		User user = new User(1,"daisy",27);
		return user;
	}
	
	@RequestMapping("/json2.do")
	@ResponseBody
	public List<User> loadUsers(){
		List<User> list = new ArrayList<User>();
		User user1 = new User(2,"zhangsan",30);
		list.add(user1);
		User user2 = new User(3,"wangwu",40);
		list.add(user2);
		return list;
	}
	
	@RequestMapping("/json3.do")
	@ResponseBody
	public Map<String,Object> loadData(){
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("id", 1);
		data.put("name", "lisi");
		data.put("age", 28);
		return data;
	}

}
