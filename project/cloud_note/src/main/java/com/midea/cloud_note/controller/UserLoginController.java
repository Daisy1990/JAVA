package com.midea.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.midea.cloud_note.entity.User;
import com.midea.cloud_note.service.UserService;
import com.midea.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	@Resource
	private UserService useService;
	
	@RequestMapping("/login.do")
	@ResponseBody //����jackson
	public NoteResult<User> execute(String name,String password){
		//System.out.println(name+","+password);
		//����UserService�����½����
		NoteResult<User>  result 
		= useService.checkLogin(name, password);
		return result;
	}
}
