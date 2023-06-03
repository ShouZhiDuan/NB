package com.nb.java.springbean.registry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: novavita-server
 * @ClassName MyBeanFactory
 * @author: duanshouzhi
 * @create: 2023-06-03 13:25
 * @description:
 **/
//@Component
public class MyBeanFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void registerBean(String beanName, Object bean) {
        ConfigurableListableBeanFactory beanFactory = ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
        beanFactory.registerSingleton(beanName, bean);
        //beanFactory.registerResolvableDependency(MyMapper.class,bean);
    }


    public <T> T getMymapper(){
        Object o = Proxy.newProxyInstance(MyMapper.class.getClassLoader(), new Class[]{MyMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("8989898989");
                return "666666";
            }
        });
        return (T) o;
    }

}