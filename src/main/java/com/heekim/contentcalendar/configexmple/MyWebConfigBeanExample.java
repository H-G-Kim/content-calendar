package com.heekim.contentcalendar.configexmple;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class MyWebConfigBeanExample {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().build();

    }

}
