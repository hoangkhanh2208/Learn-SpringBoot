package com.hoangkhanh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    SimpleBean simpleBeanConfigure(){
        return  new SimpleBean("tit");
    }
}
