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
public class HungrySingleton2 {

    private final static HungrySingleton2 SINGLETON;

    static {
        SINGLETON = new HungrySingleton2();
    }

    /**
     * private防止外部new出新的对象
     */
    private HungrySingleton2(){

    }

    public static HungrySingleton2 getInstance(){
       return SINGLETON;
    }

    public void test(){
        System.out.println("My name is HungrySingleton......");
    }

}