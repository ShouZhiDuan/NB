package com.nb.java.springbean.repository;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName NvDefaultRepository
 * @author: duanshouzhi
 * @create: 2023-06-13 11:11
 * @description:
 **/

public class NvDefaultRepository<T> implements NvRepository<T>, InvocationHandler {

    @Override
    public List<T> findAll(Object object) {
        System.out.println("======调用列表查询======");
        return new ArrayList<>();
    }

    @Override
    public T findById(Integer id) {
        System.out.println("======调用通过主键ID查询======");
        return null;
    }

    @Override
    public int update(T t) {
        System.out.println("======调用更新操作======");
        return 0;
    }

    @Override
    public T insert(T t) {
        System.out.println("======调用插入新操作======");
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 判断是否为Object父类原生方法：toString、hashCode、equals等等
        Class<?> declaringClass = method.getDeclaringClass();
        if(Object.class.equals(declaringClass)){
            return method.invoke(this,args);
        }
        System.out.println("======代理前操作======");
        Object invoke = method.invoke(this, args);
        System.out.println("======代理后操作======");
        return invoke;
    }
}