package com.nb.java.designmode.singleton.study.hungry;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName HungrySingleton
 * @author: duanshouzhi
 * @create: 2023-06-15 11:02
 * @description:
 **/
public class HungrySingleton {

    private final static HungrySingleton SINGLETON = new HungrySingleton();

    /**
     * private防止外部new出新的对象
     */
    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
       return SINGLETON;
    }

    public void test(){
        System.out.println("My name is HungrySingleton......");
    }

}