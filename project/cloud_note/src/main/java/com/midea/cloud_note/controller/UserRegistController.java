package com.midea.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.midea.cloud_note.service.UserService;
import com.midea.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserRegistController {
	@Resource
	private UserService useService;
	
	@RequestMapping("/add.do")
	@ResponseBody //µ÷ÓÃjackson
	public NoteResult<Object> execute(
			String name,String password,String nick){
		NoteResult<Object> result 
		= useService.addUser(name, password, nick);
		return result;
	}
	

}
