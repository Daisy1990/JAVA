package com.midea.cloud_note.dao;

import com.midea.cloud_note.entity.User;

public interface UserDao {
	//��½����
	public User findByName(String name);
	//ע�᷽��
	public void save(User user);
}
