package com.nb.demo.controller;

import com.nb.demo.kms.KmsTemplate;
import com.nb.global.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shouzhi@duan
 */
@RestController
public class TestController {

    @Autowired
    KmsTemplate kmsTemplate;

    @GetMapping("/test")
    public void testKms(){
       kmsTemplate.generateDEK();
       kmsTemplate.generateCMK();
    }

    @GetMapping("/test")
    public void test(){
        throw new GlobalException(-1,"测试抛出自定义异常");
    }


}
