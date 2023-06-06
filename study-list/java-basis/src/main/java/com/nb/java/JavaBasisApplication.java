package com.nb.java;

import com.nb.java.springbean.beanfactory.User;
import com.nb.java.springbean.registry.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaBasisApplication {


	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(JavaBasisApplication.class);
		ConfigurableApplicationContext run = springApplication.run(args);

		ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();

		TestService testService = beanFactory.getBean(TestService.class);
		testService.test();


	}

}
