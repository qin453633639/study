package spring.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by qinwei on 2019/5/13.
 */
@Service("my")
public class My  implements IMy{

    @Cacheable(value = "myCache")
    public String getName(String id){
        return createName(id);
    }

    private String createName(String id){
        System.out.println("1"+id);
        return "1"+id;
    }
}
