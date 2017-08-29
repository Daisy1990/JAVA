package test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midea.cloud_note.dao.UserDao;
import com.midea.cloud_note.entity.User;

public class TestUserDao {
	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		User user = dao.findByName("Andy");
		System.out.println(user);
	}
	
	@Test
	public void testSave(){
		String[] conf 
		={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		User usr01 = new User();
		usr01.setCn_user_id("082203");
		usr01.setCn_user_name("test05");
		usr01.setCn_user_nick("testnick");
		usr01.setCn_user_pwd("098798");
		usr01.setCn_user_token(null);
		dao.save(usr01);
		User user = dao.findByName("test05");
		System.out.println(user);
		
	}
	
	
	
}
