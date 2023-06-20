package com.nb.java.controller;

import com.nb.java.classloader.TestClassLoader;
import com.nb.java.javabean.TestBean;
import com.nb.java.springbean.registry.TestService;
import com.nb.java.springbean.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private TestService testService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String test(String name){
        testService.test();
        userRepository.findAll(null);
        return name;
    }

    @GetMapping("/json")
    public Object test(@RequestBody TestBean bean){
        System.out.println(bean);
        //return null;
        return bean;
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


    @PostMapping("/test2")
    public Object test2(@RequestBody HashMap map){
        return map;
    }

}