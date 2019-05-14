package spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qinwei on 2019/5/13.
 */
@Service("a")
public class A {
    @Autowired
    private B b;
}
