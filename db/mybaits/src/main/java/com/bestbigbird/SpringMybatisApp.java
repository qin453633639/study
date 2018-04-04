package com.bestbigbird;

import com.bestbigbird.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserMapper mapper = applicationContext.getBean("userMapper", UserMapper.class);
        System.out.println(mapper.findById(3).getAge());
    }
}
