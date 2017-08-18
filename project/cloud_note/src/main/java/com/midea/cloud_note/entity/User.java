package com.midea.cloud_note.entity;

import java.io.Serializable;

public class User implements Serializable{
	/*
	 * 参照cn_user表定义
	 * 属性名与字段名保持一致
	 * 属性类型与字段类型一致
	 * 实现序列化
	 * */
	private String cn_user_id;
	private String cn_user_name;
	private String cn_user_pwd;
	private String cn_user_token;
	private String cn_user_nick;
	public String getCn_user_id() {
		return cn_user_id;
	}
	public void setCn_user_id(String cn_user_id) {
		this.cn_user_id = cn_user_id;
	}
	
	public String getCn_user_name() {
		return cn_user_name;
	}
	public void setCn_user_name(String cn_user_name) {
		this.cn_user_name = cn_user_name;
	}
	public String getCn_user_pwd() {
		return cn_user_pwd;
	}
	public void setCn_user_pwd(String cn_user_pwd) {
		this.cn_user_pwd = cn_user_pwd;
	}
	public String getCn_user_token() {
		return cn_user_token;
	}
	public void setCn_user_token(String cn_user_token) {
		this.cn_user_token = cn_user_token;
	}
	public String getCn_user_nick() {
		return cn_user_nick;
	}
	public void setCn_user_nick(String cn_user_nick) {
		this.cn_user_nick = cn_user_nick;
	}
	@Override
	public String toString() {
		return "user_id="+cn_user_id+",user_name="+cn_user_name;
	}
	


}
