package com.qf.test;

import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import com.qf.pojo.UserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisDemo {

    @Test
    public void test_findAll()throws Exception{

        //1.获得读取MyBatis配置文件的流对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //2.构建SqlSession连接对象的工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //3.通过工厂获得连接对象
        SqlSession sqlSession = factory.openSession();

        //4.通过连接对象获得接口实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //查询所有
        List<User> list = userMapper.selectByExample(null);

        System.out.println(list);
    }

    @Test
    public void test_findById()throws Exception{

        //1.获得读取MyBatis配置文件的流对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //2.构建SqlSession连接对象的工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //3.通过工厂获得连接对象
        SqlSession sqlSession = factory.openSession();

        //4.通过连接对象获得接口实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //查询单个
        User user= userMapper.selectByPrimaryKey(2);

        System.out.println(user);
    }


    @Test
    public void test_findByName()throws Exception{

        //1.获得读取MyBatis配置文件的流对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //2.构建SqlSession连接对象的工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //3.通过工厂获得连接对象
        SqlSession sqlSession = factory.openSession();

        //4.通过连接对象获得接口实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        String name = "张";
        //指定条件查询
        UserExample userExample = new UserExample();
        userExample.setDistinct(true);
        UserExample.Criteria criteria = userExample.createCriteria();
        //添加条件
        criteria.andUsernameLike("%"+name+"%");

        List<User> users= userMapper.selectByExample(userExample);

        System.out.println(users);
    }
}
