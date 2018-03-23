package com.bestbigbird;

import com.bestbigbird.entity.User;
import com.bestbigbird.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
        String resource = "configure.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // list中的user和映射文件中resultType所指定的类型一致
        User user = sqlSession.getMapper(UserMapper.class).findById(1);
        System.out.println(user.getId()+"  "+user.getAge());
        user = sqlSession.selectOne("com.bestbigbird.mapper.UserMapper.findById",2);
        System.out.println(user.getId()+"  "+user.getAge());

        while (true){

        }
        //sqlSession.close();
    }
}
