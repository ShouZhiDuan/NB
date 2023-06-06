package com.nb.java.springbean;

import com.nb.java.springbean.beanfactory.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName SpringBeanUtil
 * @author: duanshouzhi
 * @create: 2023-06-02 16:54
 * @description:
 **/
@Component
public class SpringBeanUtil {

    @Autowired
    private ApplicationContext applicationContext;


    /**
     * @Description: GenericApplicationContext
     * @author duanshouzhi
     * @date 10:56 2023/6/6
     **/
    public static void genericApplicationContextRegister(){
        // 创建ApplicationContext
        GenericApplicationContext context = new GenericApplicationContext();
        // 创建bean定义
        BeanDefinition beanDefinition = new RootBeanDefinition(User.class);
        beanDefinition.getPropertyValues().add("name", "GenericApplicationContext register bean ......");
        // 注册bean定义
        context.registerBeanDefinition("user", beanDefinition);
        // 刷新ApplicationContext
        context.refresh();
        // 获取bean
        //User user = context.getBean(User.class);
        //System.out.println(user.getName());
    }


    /**
     * @Description: DefaultListableBeanFactory
     * @author duanshouzhi
     * @date 10:58 2023/6/6
     **/
    public static void defaultListableBeanFactoryRegister(){
        // 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建bean定义
        BeanDefinition beanDefinition = new RootBeanDefinition(User.class);
        beanDefinition.getPropertyValues().add("name", "value1");
        // 注册bean定义
        beanFactory.registerBeanDefinition("user", beanDefinition);
        // 获取bean
        User user = beanFactory.getBean(User.class);
    }

}