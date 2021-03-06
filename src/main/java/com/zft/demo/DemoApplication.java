package com.zft.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(DemoApplication.class, args);
		MyProcessor.setApplicationContext(c);
	}

}
