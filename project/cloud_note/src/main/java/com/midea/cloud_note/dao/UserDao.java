package com.midea.cloud_note.dao;

import com.midea.cloud_note.entity.User;

public interface UserDao {
	//登陆方法
	public User findByName(String name);
	//注册方法
	public void save(User user);
}
