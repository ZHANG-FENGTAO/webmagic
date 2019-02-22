package com.zft.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.zft.demo.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(DemoApplication.class, args);
		MyProcessor.setApplicationContext(c);
	}

}
