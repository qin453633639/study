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

        Resource resource = new ClassPathResource("application_context.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        System.out.println( beanFactory.getBean("student", Student.class).getAge());
        /*MyUserService userService = applicationContext.getBean(MyUserService.class);
        MyUser myUser = new MyUser();
        myUser.setId(16);
        myUser.setAge(16);
        userService.save(myUser);*/
    }
}
