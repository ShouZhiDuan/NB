package com.nb.java.designmode.chain;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestMain
 * @author: duanshouzhi
 * @create: 2023-07-08 14:52
 * @description:
 **/
public class TestMain {

    public static void main(String[] args) {
        Handler filterHandler = new FilterHandler(new RegistryHandler(new LoginHandler(null)));
        filterHandler.process(new Request());
    }

}