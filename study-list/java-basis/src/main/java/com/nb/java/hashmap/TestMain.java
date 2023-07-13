package com.nb.java.hashmap;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestMain
 * @author: duanshouzhi
 * @create: 2023-07-11 13:55
 * @description:
 **/
public class TestMain {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.err.println("======666666======");
        HashMap<String, Object> map = new HashMap<>(12);
        //for (int n = 0; n < 100; n++) {
           // map.put("name6","test name");
            map.put("name26","test name");
        //}
        Class<? extends HashMap> aClass = map.getClass();
        Field table = aClass.getDeclaredField("table");
        table.setAccessible(true);
        Object o = table.get(map);
        System.out.println(o);
    }

}