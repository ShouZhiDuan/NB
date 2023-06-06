package com.nb.java.springbean.beanfactory;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName StaticFactory
 * @author: duanshouzhi
 * @create: 2023-06-02 17:45
 * @description:
 **/
public class StaticFactory {
    // 静态的方法，返回User对象
    public static User getUser(){
        return new User();
    }
}