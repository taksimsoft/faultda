package com.ts.cloudfda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerCongig {

    @Bean
    public MessageListener messageListener() {
        return new MessageListener();
    }

}
