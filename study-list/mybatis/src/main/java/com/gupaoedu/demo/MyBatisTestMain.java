package com.gupaoedu.demo;

import com.gupaoedu.domain.TestTb;
import com.gupaoedu.domain.associate.TestDbAndBlog;
import com.gupaoedu.mapper.TestTbMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author dev
 */
public class MyBatisTestMain {

    private static String resource = "mybatis-config.xml";

/*    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestTbMapper mapper = sqlSession.getMapper(TestTbMapper.class);
        TestTb testDb = mapper.selectTestTbById(1,"test_tb");
        System.out.println(testDb);
    }*/

    /**
     * @Description: 嵌套结果查询测试
     * @author duanshouzhi
     * @date 15:25 2023/5/24
     * @param args
     **/
    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestTbMapper mapper = sqlSession.getMapper(TestTbMapper.class);
        TestDbAndBlog testTb = mapper.selectTestDbAndBlogRst(1);
        System.out.println(testTb);
    }




}