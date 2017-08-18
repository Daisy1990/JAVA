package com.midea.cloud_note.dao;

import com.midea.cloud_note.entity.User;

public interface UserDao {
	public User findByName(String name);
}
