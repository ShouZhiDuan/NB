package com.nb.demo.controller;

import com.nb.common.base.response.CommonResult;
import com.nb.global.exception.handler.GlobalException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public CommonResult test(){
        throw new GlobalException(-1,"测试抛出自定义异常");
        //return CommonResult.error(-1,"测试");
    }


}
