package com.pw;

import com.qw.common.api.user.api.UserApi;
import com.qw.common.api.user.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class UserApp {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
       UserApi userApi = ctx.getBean(UserApi.class);
        User user = userApi.findById(100L);
        System.out.println(1);
    }
}
