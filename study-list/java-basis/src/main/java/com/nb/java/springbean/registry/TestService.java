package com.nb.java.springbean.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestService
 * @author: duanshouzhi
 * @create: 2023-06-03 15:04
 * @description:
 **/
@Component
public class TestService {

    private final MyMapper myMapper;

    public TestService(MyMapper myMapper) {
        this.myMapper = myMapper;
    }


    public void test(){
        System.out.println("======TestService======");
        myMapper.test();
    }

}