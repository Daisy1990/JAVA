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

	public NoteResult<Object> addUser(String name,String password,String nick) {
		
		//接收结果数据
		NoteResult<Object> result 
			=new NoteResult<Object>();
		// 检查用户名是否已经存在	
		//按照参数name查询数据库
		User hasUser = userDao.findByName(name);
		
		if(hasUser !=null){
			result.setStatus(1);
			result.setMsg("用户名已经被占用！");
			return result;
		}else{
			//添加用户
			//首先对传过来的密码进行加密
			String md5Pwd = NoteUtil.md5(password);
			//生成主键id 并且加密
			String id = NoteUtil.md5(NoteUtil.createId());
			User user1 = new User();
			user1.setCn_user_id(id);
			user1.setCn_user_name(name);
			user1.setCn_user_pwd(md5Pwd);
			user1.setCn_user_nick(nick);
			//插入用户数据
			userDao.save(user1);
		}
		result.setStatus(0);
		result.setMsg("注册成功！");
		//result.setData(user1);
		return result;
		
	}
	
}
