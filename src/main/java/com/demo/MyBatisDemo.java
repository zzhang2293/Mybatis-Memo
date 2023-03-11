package com.demo;

import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {
    public static void main(String[] args) throws Exception {
        // 1. load mybatis main xml file, then get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. get SqlSession object from the factory
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // select all, it returns a list
        List<User> users = sqlSession.selectList("User.selectAll");
        System.out.println(users);
        // release
        sqlSession.close();
    }
}
