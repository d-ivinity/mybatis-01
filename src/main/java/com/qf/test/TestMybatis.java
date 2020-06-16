//package com.qf.test;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.qf.pojo.User;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Test;
//
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestMybatis {
//
//    @Test
//    public void test_findAll()throws Exception{
//
//        //1.获得读取MyBatis配置文件的流对象
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//
//        //2.构建SqlSession连接对象的工厂
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//
//        //3.通过工厂获得连接对象
//        SqlSession sqlSession = factory.openSession();
//
//        //4.通过连接对象获得接口实现类对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//        //5.调用接口中的方法
//        System.out.println(userMapper.findAll());
//
//
//    }
//
//
//    @Test
//    public void test_findByUserName()throws Exception{
//
//        //1.获得读取MyBatis配置文件的流对象
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//
//        //2.构建SqlSession连接对象的工厂
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//
//        //3.通过工厂获得连接对象
//        SqlSession sqlSession = factory.openSession();
//
//        //4.通过连接对象获得接口实现类对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//        //5.调用接口中的方法
//        System.out.println(userMapper.findByUserName("李四"));
//
//    }
//
//    @Test
//    public void test_UpdateUser()throws Exception{
//
//        //1.获得读取MyBatis配置文件的流对象
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//
//        //2.构建SqlSession连接对象的工厂
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//
//        //3.通过工厂获得连接对象
//        SqlSession sqlSession = factory.openSession();
//
//        //4.通过连接对象获得接口实现类对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//        User user = new User();
//        user.setId(8);
//        user.setUsername("jack");
//        user.setAddress("广州");
//
//        //5.调用接口中的方法
//        userMapper.UpdateUser(user);
//
//        sqlSession.commit();
//
//    }
//
//
//    @Test
//    public void test_findAllById()throws Exception{
//
//        //1.获得读取MyBatis配置文件的流对象
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//
//        //2.构建SqlSession连接对象的工厂
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//
//        //3.通过工厂获得连接对象
//        SqlSession sqlSession = factory.openSession();
//
//        //4.通过连接对象获得接口实现类对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(2);
//        list.add(5);
//        list.add(8);
//
//        //5.调用接口中的方法
//        List<User> users = userMapper.findAllById(list);
//
//        System.out.println(users);
//
//    }
//
//    @Test
//    public void test_findById()throws Exception{
//
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//        SqlSession sqlSession = factory.openSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//        List<User> user1 = userMapper.findById(2);
//        //一旦执行了commit(),close(),clearCache()等方法，一级将清空
//        //sqlSession.clearCache();
//        //sqlSession.close();
//
////        sqlSession = factory.openSession();
////        UserMapper userMapper1= sqlSession.getMapper(UserMapper.class);
////        List<User> user2 = userMapper1.findById(2);
//        List<User> user2 = userMapper.findById(2);
//        //证明一级缓存（sqlSession级别的缓存）存在
//        System.out.println(user1 == user2);
//
//    }
//
//    @Test
//    public void test_findById2()throws Exception{
//
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//        SqlSession sqlSession1 = factory.openSession();
//        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
//
//        List<User> user1 = userMapper1.findById(2);
//        sqlSession1.close();
//
//        SqlSession sqlSession2 = factory.openSession();
//        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
//        List<User> user2 = userMapper2.findById(2);
//
//        SqlSession sqlSession3 = factory.openSession();
//        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
//        List<User> user3 = userMapper3.findById(2);
//
//    }
//
//
//    @Test
//    public void test_findAllByPageInfo()throws Exception{
//        //1.获得读取MyBatis配置文件的流对象
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        //2.构建SqlSession连接对象的工厂
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//        //3.通过工厂获得连接对象
//        SqlSession sqlSession = factory.openSession();
//        //4.通过连接对象获得接口实现类对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//        //pageNum：当前页
//        //pageSize：每页显示条数
//        PageHelper.startPage(2,2);
//        List<User> list = userMapper.findAll();
//        //分页信息对象
//        PageInfo<User> pageInfo = new PageInfo<User>(list);
//
//        System.out.println(pageInfo);
//    }
//}
