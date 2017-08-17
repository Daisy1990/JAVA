package com.midea.dao;

import com.midea.entity.User;

public interface UserDao {
	public User findByName(String name);
}
