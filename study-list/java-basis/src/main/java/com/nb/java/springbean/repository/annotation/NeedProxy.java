package com.nb.java.springbean.repository.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName NeedProxy
 * @author: duanshouzhi
 * @create: 2023-06-13 11:51
 * @description:
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedProxy {
    String value() default "";
}
