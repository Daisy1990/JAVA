package com.midea.cloud_note.service;

import com.midea.cloud_note.entity.User;
import com.midea.cloud_note.util.NoteResult;

public interface UserService {
	//�ȶ��û���+����
	public NoteResult<User> checkLogin(String name,String password);
}
