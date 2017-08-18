package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midea.cloud_note.dao.UserDao;
import com.midea.cloud_note.entity.User;
import com.midea.cloud_note.service.UserService;
import com.midea.cloud_note.util.NoteResult;

public class TestUserService {
	UserService service;
	@Before
	public void init(){
		String[] conf ={"conf/spring-mybatis.xml",
						"conf/spring-mvc.xml"};
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext(conf);
		service
		= ctx.getBean("userService",UserService.class);
		
	}
	@Test //����-1��Ԥ�ڽ�����û���������
	public void test1(){
		NoteResult<User> result 
		=service.checkLogin("dd", "1234");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	@Test //����-2��Ԥ�ڽ�������벻��ȷ
	public void test2(){
		NoteResult<User> result 
		=service.checkLogin("Andy", "1234");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
		
	}
	@Test //����-3��Ԥ�ڽ������½�ɹ�
	public void test3(){
		NoteResult<User> result 
		=service.checkLogin("Andy", "112");
//		System.out.println(result.getStatus());
//		System.out.println(result.getMsg());
//		System.out.println(result.getData());
		System.out.println(result);
	}
}
