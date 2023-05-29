package com.nb.java.designmode.proxy.jdkproxy;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestInterfaceImpl
 * @author: duanshouzhi
 * @create: 2023-05-26 17:51
 * @description:
 **/
public class TestInterfaceImpl implements TestInterface{

    @Override
    public String test(Integer id) {
        System.out.println("Hello TestInterfaceImpl ...");
        return "Hello TestInterfaceImpl ...";
    }
}