package com.gupaoedu.demo;

import com.alibaba.fastjson.JSON;
import com.gupaoedu.domain.associate.TestDbAndBlog;
import com.gupaoedu.mapper.TestTbMapper;
import lombok.Data;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.lang.model.element.NestingKind;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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
//    public static void main(String[] args) throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TestTbMapper mapper = sqlSession.getMapper(TestTbMapper.class);
//        TestDbAndBlog testTb = mapper.selectTestDbAndBlogRst(1);
//        System.out.println(testTb);
//    }



    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestTbMapper mapper = sqlSession.getMapper(TestTbMapper.class);
        TestDbAndBlog testTb = mapper.selectTestTbById2(1);
        TestDbAndBlog testTb2 = mapper.selectTestTbById2(1);
        System.out.println(testTb);
    }


//    public static void main(String[] args) {
//        HashMap<String, Map> map = new HashMap<>();
//
///*        Blog blog = new Blog();
//        blog.setBid(1);
//        blog.setName("blog name");
//        blog.setAuthorId(666);*/
//
//        HashMap<String, Object> map1 = new HashMap<>();
//        map1.put("name","几把");
//
//        map.put("map1",map1);
//        map.put("map2",map1);
//
//        String blog1 = map.get("map1").toString();
//        System.out.println(blog1);
//
//        System.out.println(map.toString());
//        System.out.println(map);
//        System.out.println(JSON.toJSONString(map));
//
//
//        Person person = new Person();
//        person.setName("666");
//        System.out.println(person);
//
//    }
//
//
//
//     @Data
//    static class Person{
//        private String name;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }

}