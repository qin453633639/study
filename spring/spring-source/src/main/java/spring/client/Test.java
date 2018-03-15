package spring.client;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import spring.aop.OrderServiceimpl;
import spring.aop.TitleServiceImpl;
import spring.entity.Student;
import spring.entity.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] arge){
       benaPareAndInit();

}

    public static  void benaPareAndInit(){

        //spring如何初始化有两种方式 beanFactory applicationContext
       /* Resource resource = new ClassPathResource("application.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        OrderServiceimpl s =   beanFactory.getBean(OrderServiceimpl.class);
        s.count();*/


        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        System.out.println(ctx.getBean(OrderServiceimpl.class).count());
       /* System.out.println(ctx.getBean(OrderServiceimpl.class).getClass());
        System.out.println(ctx.getBean(TitleServiceImpl.class).getClass());*/





       /*
        AbstractFruit abstractFruit = (AbstractFruit)beanFactory.getBean("abstractFruit");
        abstractFruit.showMe();
        System.out.println(abstractFruit.getClass());*/
    }



}

