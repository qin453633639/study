package spring.cache;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qinwei on 2019/5/13.
 */
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application_cache.xml");
        IMy my = ctx.getBean("my", IMy.class);
        my.getName("qinwei");
        my.getName("qinwei");
        my.getName("qinwei");
        my.getName("qinwei");
        my.getName("qinwei");
        my.getName("qinwei");
    }
}
