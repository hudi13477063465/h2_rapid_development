package com.boot.security.server;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;







/**
 * 启动类
 * 
 *
 */
@SpringBootApplication()

// @MapperScan(basePackages = "com.boot.security.server.mapper.**")
public class SecurityApplication {

	public static void main(String[] args) throws IOException {
	
		ConfigurableApplicationContext run = new SpringApplicationBuilder(SecurityApplication.class).headless(false).run(args);
	}
}
