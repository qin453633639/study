package com.bestbigbird;

import com.bestbigbird.mapper.UserMapper;
import com.bestbigbird.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = applicationContext.getBean(  UserService.class);
        userService.aa();
        userService.aa();
    }
}
