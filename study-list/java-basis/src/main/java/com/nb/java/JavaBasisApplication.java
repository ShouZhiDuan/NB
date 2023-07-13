package com.nb.java;

import com.nb.java.springbean.registry.TestService;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JavaBasisApplication {


	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(JavaBasisApplication.class);
		ConfigurableApplicationContext run = springApplication.run(args);

		ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();

		TestService testService = beanFactory.getBean(TestService.class);
		testService.test();

		List<byte[]> list = new ArrayList<>();


		new Thread(() -> {
			while (true){
				System.out.println("===每次添加一个byte[10]字节数组===");
				list.add(new byte[10]);
			}
		},"模拟Java运行时CPU、内存占用过高的线程").start();

	}

}
