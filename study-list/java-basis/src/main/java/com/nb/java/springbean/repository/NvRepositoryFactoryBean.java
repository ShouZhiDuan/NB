package com.nb.java.springbean.repository;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName NvRepositoryFactoryBean
 * @author: duanshouzhi
 * @create: 2023-06-13 11:23
 * @description:
 **/
public class NvRepositoryFactoryBean<T> implements FactoryBean<T> {

    private Class<T> interfaceType;

    public NvRepositoryFactoryBean(Class interfaceType){
        this.interfaceType = interfaceType;
    }

    /**
     * 获取实例Bean
     * @return
     * @throws Exception
     */
    @Override
    public T getObject() throws Exception {
        T object = (T) Proxy.newProxyInstance(
                this.interfaceType.getClassLoader(),
                new Class[]{this.interfaceType},
                new NvDefaultRepository<T>()
        );
        return object;
    }

    /**
     * 获取实例Bean Class Type
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return interfaceType;
    }

    /**
     * 获取Bean是否为单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }


    /**
     * 测试动态代理
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        NvRepositoryFactoryBean<UserRepository<User>> userRepositoryNvRepositoryFactoryBean =
                new NvRepositoryFactoryBean<UserRepository<User>>(UserRepository.class);

        UserRepository<User> userUserRepository = userRepositoryNvRepositoryFactoryBean.getObject();

        userUserRepository.findAll(null);
    }
}