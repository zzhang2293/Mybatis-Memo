package com.demo;

import com.mapper.UserMapper;
import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo2 {
    public static void main(String[] args) throws Exception {
        // load mybatis core xml file, and get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // get sqlSession Object
        SqlSession session = sqlSessionFactory.openSession();

        // then execute sql
        //List<User> users = session.selectList("User.selectAll"); this one is hard code. we want to use another way
        // get UserMapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
//        UserMapper userMapper1 = new UserMapper() {
//            @Override
//            public List<User> selectAll() {
//                return null;
//            }
//        }
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

}
