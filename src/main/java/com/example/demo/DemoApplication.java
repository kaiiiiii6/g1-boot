package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		System.out.println("container        : " + ctx.getClass().getName());
		System.out.println("bean count       : " + ctx.getBeanDefinitionCount());
		System.out.println("has helloService : " + ctx.containsBean("helloService"));

		HelloService a = ctx.getBean(HelloService.class);
		HelloService b = ctx.getBean(HelloService.class);
		System.out.println("same?"+(a==b));
		System.out.println("singleton?"+ctx.isSingleton("helloService"));
	}

}
