package com.cafebabe.clouddemo.zookeeper.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EurekaConsumerConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getResetTemplate(){
        return  new RestTemplate();
    }
}
