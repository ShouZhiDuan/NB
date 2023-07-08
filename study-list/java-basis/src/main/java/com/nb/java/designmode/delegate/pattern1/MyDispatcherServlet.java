package com.nb.java.designmode.delegate.pattern1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName MyDispatcherServlet
 * @author: duanshouzhi
 * @create: 2023-07-08 17:02
 * @description:
 **/
public class MyDispatcherServlet {

    private final static HashMap<String, InvokeMethod> INVOKE_METHODS;

    static {
        INVOKE_METHODS = new HashMap<>();
        //解析MyController中所有的方法信息：注解数据、方法本身
        MyController target = new MyController();
        Method[] declaredMethods = MyController.class.getDeclaredMethods();
        if(declaredMethods != null || declaredMethods.length > 0){
            for (Method declaredMethod : declaredMethods) {
                boolean getMappingPresent = declaredMethod.isAnnotationPresent(GetMapping.class);
                boolean postMappingPresent = declaredMethod.isAnnotationPresent(PostMapping.class);
                if(getMappingPresent){
                    System.out.println("======Get注解处理======");
                    GetMapping annotation = declaredMethod.getAnnotation(GetMapping.class);
                    String url = annotation.name();
                    System.out.println("当前方法的注解URL：" + url);
                    InvokeMethod invokeMethod = new InvokeMethod(target, declaredMethod, null);
                    INVOKE_METHODS.put(url,invokeMethod);
                }
                if(postMappingPresent){
                    System.out.println("======Get注解处理======");
                    PostMapping annotation = declaredMethod.getAnnotation(PostMapping.class);
                    String url = annotation.name();
                    System.out.println("当前方法的注解URL：" + url);
                    InvokeMethod invokeMethod = new InvokeMethod(target, declaredMethod, new Object[]{"测试参数"});
                    INVOKE_METHODS.put(url,invokeMethod);
                }
            }
        }
    }

    /**
     * 委派分发
     * @param url
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void handRequestByUrl(String url) throws InvocationTargetException, IllegalAccessException {
        InvokeMethod invokeMethod = INVOKE_METHODS.get(url);
        if(invokeMethod == null){
            System.out.println("===404===");
        }else {
            Object invoke = invokeMethod.getMethod().invoke(invokeMethod.getTarget(), invokeMethod.getParams());
        }
    }

}