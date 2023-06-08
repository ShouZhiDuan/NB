package com.nb.java;

import com.nb.java.springbean.registry.TestService;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

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
