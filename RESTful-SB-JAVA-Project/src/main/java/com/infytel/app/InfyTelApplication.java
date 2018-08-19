package com.infytel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.infytel.app")
public class InfyTelApplication {

	public static void main(String[] args) {
		String profile;
		System.setProperty("spring.profiles.active", "local");
		if(args.length>=1) {
			profile = args[0];
			System.setProperty("spring.profiles.active", profile);
		}
		
		SpringApplication.run(InfyTelApplication.class, args);
	}

}
