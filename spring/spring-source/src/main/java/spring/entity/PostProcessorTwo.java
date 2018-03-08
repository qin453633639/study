package spring.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by qinwei on 2018/1/19.
 */
public class PostProcessorTwo implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" PostProcessorTwo -- postProcessBeforeInitialization");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" PostProcessorTwo -- postProcessAfterInitialization");
        return bean;
    }
}
