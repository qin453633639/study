package spring.tx;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import spring.entity.Student;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application_txg.xml");

        MyUserService userService = applicationContext.getBean(MyUserService.class);
        MyUser myUser = new MyUser();
        myUser.setId(17);
        myUser.setAge(17);
        userService.save(myUser);

        int a = 7;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };

        r = () -> System.out.println(1);
    }
}
