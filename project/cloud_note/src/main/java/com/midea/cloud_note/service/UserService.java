package com.midea.cloud_note.service;

import com.midea.cloud_note.entity.User;
import com.midea.cloud_note.util.NoteResult;

public interface UserService {
	//比对用户名+密码
	public NoteResult<User> checkLogin(String name,String password);
	//用户注册
	public NoteResult<Object> addUser(String name,String password,String nick);
	
}
