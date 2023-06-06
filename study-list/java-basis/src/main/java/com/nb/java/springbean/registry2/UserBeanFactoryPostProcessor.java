package com.nb.java.springbean.registry2;

import com.nb.java.springbean.beanfactory.User;
import com.nb.java.springbean.registry.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName UserBeanFactoryPostProcessor
 * @author: duanshouzhi
 * @create: 2023-06-06 11:30
 * @description:
 **/
@Component
public class UserBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        bdb.addPropertyValue("name", "UserBeanFactoryPostProcessor Test Name");
        factory.registerBeanDefinition("user", bdb.getBeanDefinition());
        System.out.println();
    }
}