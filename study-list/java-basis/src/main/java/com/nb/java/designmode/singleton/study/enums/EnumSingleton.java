package com.nb.java.designmode.singleton.study.enums;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName EnumSingleton
 * @author: duanshouzhi
 * @create: 2023-06-15 17:18
 * @description: we
 **/

public enum EnumSingleton {

    SINGLETON,SINGLETON2;


    EnumSingleton(){

    }

   final static void test(){
        System.out.println("======enum======");
    }

    public static void main(String[] args) {
        EnumSingleton.test();

    }

}
