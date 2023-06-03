package com.nb.java.springbean.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMain {

    private static String xmlPath = "E:\\dsz-git-work\\NB\\study-list\\java-basis\\src\\main\\resources\\spring-config.xml";

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        //MyBeanFactory myBeanFactory = applicationContext.getBean(MyBeanFactory.class);

        //MyMapper mymapper = myBeanFactory.getMymapper();
        //myBeanFactory.registerBean("myMapper",mymapper);

        //MyMapper bean = applicationContext.getBean(MyMapper.class);
        //bean.test();

        TestService testService = applicationContext.getBean(TestService.class);
        testService.test();

    }
}