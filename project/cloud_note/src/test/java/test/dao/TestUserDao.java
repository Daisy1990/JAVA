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
	
	
}
