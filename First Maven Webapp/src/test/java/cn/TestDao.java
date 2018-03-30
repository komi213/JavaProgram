package cn;

import java.text.DecimalFormat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.dao.UserTMapper;
import com.study.model.UserT;

public class TestDao {
	@Test
    public void selectAllInfo(){  
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserTMapper userTMapper = applicationContext.getBean(UserTMapper.class);

        UserT selectById = userTMapper.selectById(1);  
        System.out.println(selectById);  
        
        DecimalFormat decimalFormat=new DecimalFormat(".00");
	    System.out.println(decimalFormat.format(1.245));
    }  
}
