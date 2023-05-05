package com.nb.demo.controller;

import com.nb.global.exception.GlobalException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dev
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public void test(){
        throw new GlobalException(-1,"测试抛出自定义异常");
    }


}
