package spring.usertag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by qinwei on 2018/2/10.
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}