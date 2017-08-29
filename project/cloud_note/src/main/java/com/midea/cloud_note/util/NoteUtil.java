package com.midea.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;
import org.apache.tomcat.util.codec.binary.Base64;

public class NoteUtil {
	/*
	 * ����UUID�㷨��������
	 * */
	public static String createId(){
		
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		return id.replace("-", "");
		//return uuid.toString();
	}
	
	public static String createToken(){
		return createId().replaceAll("-", "");//ȥ��"-"
	}
	
	public static String md5(String pwd){
		//����ժҪ�㷨
		try {
			//��msg��Ϣ����md5����
			MessageDigest md = 
					MessageDigest.getInstance("MD5");
			byte[] input = pwd.getBytes();
			byte[] output = md.digest(input);
			//��base64�㷨��output���ܺ���ֽ�����ת���ַ���
			return Base64.encodeBase64String(output);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void main(String[] args){
		//System.out.println(md5("112"));
		//System.out.println(md5("112"));
		//������������
		System.out.println(createId());
		System.out.println(md5(createId()));
	}
	
}
