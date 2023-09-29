package com.heekim.contentcalendar;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {



		SpringApplication.run(Application.class, args);






		/*
		//MyWebConfigBeanExample
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		System.out.println(restTemplate);
		*/

	}
	//run more code
}
