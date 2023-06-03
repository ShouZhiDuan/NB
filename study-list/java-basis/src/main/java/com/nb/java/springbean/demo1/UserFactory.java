package com.nb.java.springbean.demo1;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName UserFactory
 * @author: duanshouzhi
 * @create: 2023-06-02 17:45
 * @description:
 **/
public class UserFactory {
    //普通的方法，返回User对象
    //不能通过类名调用，需要通过对象调用
    public User getUser(){
        return new User();
    }
}