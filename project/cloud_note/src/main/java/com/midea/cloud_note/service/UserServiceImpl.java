package com.midea.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.midea.cloud_note.dao.UserDao;
import com.midea.cloud_note.entity.User;
import com.midea.cloud_note.util.NoteResult;
import com.midea.cloud_note.util.NoteUtil;

@Service("userService")//扫描的Spring容器
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;

	public NoteResult<User> checkLogin(String name, String password) {
		//接收结果数据
		NoteResult<User> result 
			=new NoteResult<User>();
		//按照参数name查询数据库
		User user = userDao.findByName(name);
		//用户名检测
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户名不存在！");
			return result;
		}
		//检测密码
		String md5Password
		= NoteUtil.md5(password);
		if(!user.getCn_user_pwd().equals(md5Password)){
			result.setStatus(2);
			result.setMsg("密码错误！");
			return result;
		}
		result.setStatus(0);
		result.setMsg("登陆成功！");
		result.setData(user);
		return result;
	}
	
}
