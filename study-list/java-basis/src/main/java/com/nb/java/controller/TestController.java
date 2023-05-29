package com.nb.java.controller;

import com.nb.java.classloader.TestClassLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestController
 * @author: duanshouzhi
 * @create: 2023-05-29 19:15
 * @description:
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(String name){
        return name;
    }

    @GetMapping("/refresh")
    public String refresh() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String classPath = "E:\\dsz-git-work\\NB\\study-list\\java-basis\\src\\classloader";
        TestClassLoader testClassLoader = new TestClassLoader(classPath);
        Class<?> clazz = testClassLoader.loadClass("com.test.myclass.MyClass");
        Constructor<?> constructor = clazz.getConstructor(null);
        Object o = constructor.newInstance();
        Method sayNameMethod = clazz.getMethod("sayName2");
        String invoke = (String) sayNameMethod.invoke(o);
        return invoke;
    }

}