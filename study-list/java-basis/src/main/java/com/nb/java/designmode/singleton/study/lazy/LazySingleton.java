package com.nb.java.designmode.singleton.study.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName LazySingleton
 * @author: duanshouzhi
 * @create: 2023-06-15 11:22
 * @description:
 **/
public class LazySingleton {

    private static LazySingleton lazySingleton;

    protected synchronized static LazySingleton getInstance(){
        if(Objects.isNull(lazySingleton)){
            lazySingleton = new LazySingleton();
            return lazySingleton;
        }
        return lazySingleton;
    }

    public void test(){
        System.out.println("My name is LazySingleton ......");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingleton instance = LazySingleton.getInstance();
            }
        },"线程1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingleton instance = LazySingleton.getInstance();
            }
        },"线程2");

        thread1.start();
        thread2.start();

        System.out.println("666666");

    }


//    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class lazySingletonClass = LazySingleton.class;
//        Constructor constructor = lazySingletonClass.getDeclaredConstructor(null);
//        //constructor.setAccessible(true);
//        Object lazySingleton1 = constructor.newInstance();
//        Object lazySingleton2 = constructor.newInstance();
//        System.out.println(lazySingleton1);
//        System.out.println(lazySingleton2);
//
//    }



}