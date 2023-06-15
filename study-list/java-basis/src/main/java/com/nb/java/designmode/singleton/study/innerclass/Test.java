package com.nb.java.designmode.singleton.study.innerclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName Test
 * @author: duanshouzhi
 * @create: 2023-06-15 14:29
 * @description:
 **/
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<InnerClassSingleTon> innerClassSingleTonClass = InnerClassSingleTon.class;
        Constructor<InnerClassSingleTon> constructor = innerClassSingleTonClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        InnerClassSingleTon innerClassSingleTon = constructor.newInstance(null);

    }
}