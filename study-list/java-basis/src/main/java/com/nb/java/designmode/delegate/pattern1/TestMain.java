package com.nb.java.designmode.delegate.pattern1;

import java.lang.reflect.InvocationTargetException;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestMain
 * @author: duanshouzhi
 * @create: 2023-07-08 17:22
 * @description: 测试模拟浏览器请求
 **/
public class TestMain {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MyDispatcherServlet dispatcherServlet = new MyDispatcherServlet();
        // 1、模拟请求 /test1
        dispatcherServlet.handRequestByUrl("/test1");
        // 2、模拟请求 /test2
        dispatcherServlet.handRequestByUrl("/test2");
    }
}