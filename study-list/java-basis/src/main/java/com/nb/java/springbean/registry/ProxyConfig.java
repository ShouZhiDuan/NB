package com.nb.java.springbean.registry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName ProxyConfig
 * @author: duanshouzhi
 * @create: 2023-06-03 15:20
 * @description:
 **/
@Configuration
public class ProxyConfig {
    @Bean
    public MyMapper myMapper() {
        MyMapper myMapper = (MyMapper) Proxy.newProxyInstance(MyMapper.class.getClassLoader(), new Class[]{MyMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("8989898989");
                return "666666";
            }
        });
        return myMapper;
    }
}