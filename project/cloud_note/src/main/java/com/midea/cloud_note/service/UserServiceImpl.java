package com.midea.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.midea.cloud_note.dao.UserDao;
import com.midea.cloud_note.entity.User;
import com.midea.cloud_note.util.NoteResult;
import com.midea.cloud_note.util.NoteUtil;

@Service("userService")//ɨ���Spring����
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;

	public NoteResult<User> checkLogin(String name, String password) {
		//���ս������
		NoteResult<User> result 
			=new NoteResult<User>();
		//���ղ���name��ѯ���ݿ�
		User user = userDao.findByName(name);
		//�û������
		if(user == null){
			result.setStatus(1);
			result.setMsg("�û��������ڣ�");
			return result;
		}
		//�������
		String md5Password
		= NoteUtil.md5(password);
		if(!user.getCn_user_pwd().equals(md5Password)){
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		result.setStatus(0);
		result.setMsg("��½�ɹ���");
		result.setData(user);
		return result;
	}
	
}
