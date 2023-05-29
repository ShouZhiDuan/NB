package com.nb.java.designmode.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestInvocationHandler
 * @author: duanshouzhi
 * @create: 2023-05-26 17:52
 * @description:
 **/
public class TestInvocationHandler<T> implements InvocationHandler {

    private T object;

    public TestInvocationHandler(T object) {
        this.object = object;
    }

    T getProxy(){
        T o = (T) Proxy.newProxyInstance(
                object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("======进入代理======");
        Object invoke = method.invoke(object, args);
        return null;
    }


    public static void main(String[] args) {
        // 构建目标
        TestInterface proxy3 = new TestInterface() {
            @Override
            public String test(Integer id) {
                System.out.println("6666666666666666");
                return "898989";
            }
        };
        // 构建代理类
        TestInterface proxy2 = (TestInterface) Proxy.newProxyInstance(TestInterface.class.getClassLoader(),proxy3.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("========12345678=========");
                Object invoke = method.invoke(proxy3, args);
                return invoke;
            }
        });
        String test = proxy2.test(6);
        System.out.println(test);
    }

}