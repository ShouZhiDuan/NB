package com.nb.demo;

import com.nb.dingding.DingDingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author dev
 */
@Slf4j
@SpringBootApplication
public class DemoApplication {


    private final DingDingUtil dingDingUtil;

    public DemoApplication(DingDingUtil dingDingUtil) {
        this.dingDingUtil = dingDingUtil;
        log.info("【DemoApplication】构造初始");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        DingDingUtil bean = run.getBean(DingDingUtil.class);
        bean.postWithJson("");
        log.info("【SPRINGBOOT】启动成功");
    }

}
