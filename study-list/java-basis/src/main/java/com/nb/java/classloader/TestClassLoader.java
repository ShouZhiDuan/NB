package com.nb.java.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestClassLoader
 * @author: duanshouzhi
 * @create: 2023-05-29 15:47
 * @description:
 **/
public class TestClassLoader extends ClassLoader{
    private String classPath;

    public TestClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getDate(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }


    private byte[] getDate(String name) {
        String path = classPath + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
        System.out.println("class path : " + path);
        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = is.read(buffer)) != -1) {
                stream.write(buffer, 0 ,num);
            }
            return stream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 自定义class类路径
        String classPath = "E:\\dsz-git-work\\NB\\study-list\\java-basis\\src\\classloader";
        // 自定义的类加载器实现：TestClassLoader
        TestClassLoader testClassLoader = new TestClassLoader(classPath);
        // 通过自定义类加载器加载
        Class<?> clazz = testClassLoader.loadClass("com.test.myclass.MyClass");
        Constructor<?> constructor = clazz.getConstructor(null);
        Object o = constructor.newInstance();
        Method sayNameMethod = clazz.getMethod("sayName");
        sayNameMethod.invoke(o);

        // 这里的打印应该是我们自定义的类加载器：TestClassLoader
        System.out.println(clazz.getClassLoader());
    }



}