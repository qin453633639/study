package spring.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application_tx.xml");
        MyUserService userService = applicationContext.getBean(MyUserService.class);
        MyUser myUser = new MyUser();
        myUser.setId(16);
        myUser.setAge(16);
        userService.save(myUser);
    }
}
