package com.bestbigbird;

import com.bestbigbird.entity.User;
import com.bestbigbird.mapper.UserMapper;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        String resource = "configure.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂，传 入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();
        // list中的user和映射文件中resultType所指定的类型一致
        User u = (User)sqlSession.selectOne("com.bestbigbird.mapper.UserMapper.findById",5);
        System.out.println(u.getId()+"  --   "+u.getAge());
        sqlSession.close();


        sqlSession = sqlSessionFactory.openSession();
        u = (User)sqlSession.selectOne("com.bestbigbird.mapper.UserMapper.findById",3);
        System.out.println(u.getId()+"  --   "+u.getAge());
        sqlSession.close();

    }


    public void aa() throws IOException {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        String resource = "configure.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        String path = "mapper/UserMapper.xml";
        ErrorContext.instance().resource(path);
        InputStream input = Resources.getResourceAsStream(path);
        XMLMapperBuilder mapperParser = new XMLMapperBuilder(input, sqlSessionFactory.getConfiguration(), path,
                sqlSessionFactory.getConfiguration().getSqlFragments());
        mapperParser.parse();


        SqlSession sqlSession = sqlSessionFactory.openSession();
        // list中的user和映射文件中resultType所指定的类型一致
        UserMapper mapper = sqlSession.getMapper(UserMapper.class) ;


        User u = null;
        try {
            u = mapper.findById(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(u.getId()+"  --   "+u.getAge());


        sqlSession.close();
    }


}
