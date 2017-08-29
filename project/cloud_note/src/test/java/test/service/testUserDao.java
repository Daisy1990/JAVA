package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midea.cloud_note.dao.UserDao;
import com.midea.cloud_note.entity.User;
import com.midea.cloud_note.util.NoteUtil;

public class testUserDao {
	UserDao userDao;
	@Before
	public void init(){
		String[] conf ={"conf/spring-mybatis.xml",
						"conf/spring-mvc.xml"};
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext(conf);
		userDao
		= ctx.getBean("userDao",UserDao.class);
		
	}
	@Test
	public void testSave(){
		
		String uuid = NoteUtil.createId();
		String md5Id = NoteUtil.md5(uuid);
		String pwd = NoteUtil.md5("123456");
		User user = new User();
		user.setCn_user_id(md5Id);
		user.setCn_user_name("stacy");
		user.setCn_user_nick("stacy123");
		user.setCn_user_pwd(pwd);
		userDao.save(user);
		System.out.println(user);
	}

}
