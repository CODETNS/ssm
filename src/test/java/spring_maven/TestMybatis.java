package spring_maven;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.alex.dto.User;
import com.alex.service.IUserService;
import com.alibaba.fastjson.JSON;
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TestMybatis {
	 private static Logger logger = Logger.getLogger(TestMybatis.class);  
	  private ApplicationContext ac = null;  
	    @Resource  
	    private IUserService userService = null;  
	  
	  @Before  
	  public void before() {  
	      ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");  
	      userService = (IUserService) ac.getBean("userService");  
	  }  
	  
	    @Test  
	    public void test1() {  
	        User user = userService.getUserById(1);  
	        // System.out.println(user.getUserName());  
	        // logger.info("Öµ£º"+user.getUserName());  
	        logger.info(JSON.toJSONString(user));  
	    }  
}
