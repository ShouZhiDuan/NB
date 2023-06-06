package com.nb.java.springbean.beanfactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestMain
 * @author: duanshouzhi
 * @create: 2023-06-02 17:47
 * @description:  https://blog.csdn.net/qq_33229669/article/details/114622423
 **/
public class TestMain {

    private static String xmlPath = "E:\\dsz-git-work\\NB\\study-list\\java-basis\\src\\main\\resources\\spring-config.xml";

    public static void main(String[] args) {
        //ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        // 获得无参构造函数创建的对象
        User user1a = (User) applicationContext.getBean("user1");
        User user1b = (User) applicationContext.getBean("user1");
        // 静态工厂创建的对象
        User user2a = (User) applicationContext.getBean("user2");
        User user2b = (User) applicationContext.getBean("user2");
        // 实例工厂创建的对象
        User user3a = (User) applicationContext.getBean("user3");
        User user3b = (User) applicationContext.getBean("user3");

        System.out.println("无参构造函数创建的对象user1 "+user1a);
        System.out.println("无参构造函数创建的对象user1 "+user1b);

        System.out.println("静态工厂创建的对象user2 "+user2a);
        System.out.println("静态工厂创建的对象user2 "+user2b);

        System.out.println("实例工厂创建的对象user3 "+user3a);
        System.out.println("实例工厂创建的对象user3 "+user3b);
    }
}