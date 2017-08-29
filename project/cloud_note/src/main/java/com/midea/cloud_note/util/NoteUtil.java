package com.midea.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;
import org.apache.tomcat.util.codec.binary.Base64;

public class NoteUtil {
	/*
	 * 利用UUID算法生成主键
	 * */
	public static String createId(){
		
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		return id.replace("-", "");
		//return uuid.toString();
	}
	
	public static String createToken(){
		return createId().replaceAll("-", "");//去掉"-"
	}
	
	public static String md5(String pwd){
		//基于摘要算法
		try {
			//将msg消息进行md5处理
			MessageDigest md = 
					MessageDigest.getInstance("MD5");
			byte[] input = pwd.getBytes();
			byte[] output = md.digest(input);
			//用base64算法将output加密后的字节数组转成字符串
			return Base64.encodeBase64String(output);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void main(String[] args){
		//System.out.println(md5("112"));
		//System.out.println(md5("112"));
		//测试生成主键
		System.out.println(createId());
		System.out.println(md5(createId()));
	}
	
}
