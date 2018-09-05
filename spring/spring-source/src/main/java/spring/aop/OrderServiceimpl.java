package spring.aop;

import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceimpl {

    public int count(){
        System.out.println("count");
        return 1;
    }
}
