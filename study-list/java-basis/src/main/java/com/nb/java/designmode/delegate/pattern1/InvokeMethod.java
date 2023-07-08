package com.nb.java.designmode.delegate.pattern1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName InvokeMethod
 * @author: duanshouzhi
 * @create: 2023-07-08 16:54
 * @description: controller里每个方法执行上下文
 **/
@Data
@AllArgsConstructor
public class InvokeMethod {

    /**
     * Controller的实例，反射的时候会用到
     */
    private Object target;

    /**
     * Controller每个方法对应的method实例
     */
    private Method method;

    /**
     * Controller每个方法对应的实参列表
     */
    private Object[] params;

}