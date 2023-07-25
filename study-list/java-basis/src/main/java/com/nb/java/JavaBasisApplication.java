package com.nb.java;

import com.nb.java.springbean.registry.TestService;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@SpringBootApplication
public class JavaBasisApplication {


	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication springApplication = new SpringApplication(JavaBasisApplication.class);
		ConfigurableApplicationContext run = springApplication.run(args);

		ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();

		TestService testService = beanFactory.getBean(TestService.class);
		testService.test();

//		List<byte[]> list = new ArrayList<>();
//		new Thread(() -> {
//			while (true){
//				System.out.println("===每次添加一个byte[10]字节数组===");
//				list.add(new byte[10]);
//			}
//		},"模拟Java运行时CPU、内存占用过高的线程").start();

		/**
		 * 模拟打开文件：内存泄漏
		 */
		while (true){
			System.out.println("读取一次文件");
			Thread.sleep(3000);
			Stream<Path> list = Files.list(Paths.get("/root/test_conf"));
		}



	}

}
