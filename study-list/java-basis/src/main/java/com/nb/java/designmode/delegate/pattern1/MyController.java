package com.nb.java.designmode.delegate.pattern1;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName MyController
 * @author: duanshouzhi
 * @create: 2023-07-08 16:58
 * @description:
 **/
public class MyController {

    @GetMapping(name = "/test1")
    public String test1(){
        System.err.println("======调用MyController.test1()方法======");
        return "OK";
    }

    @PostMapping(name = "/test2")
    public String test2(String msg){
        System.err.println("======调用MyController.test2("+msg+")方法======");
        return "OK";
    }

}