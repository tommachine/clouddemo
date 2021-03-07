package com.cafebabe.clouddemo.zookeeper.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.cafebabe.clouddemo.eureka.provider.dao"})
@EnableEurekaClient
public class EurekaProviderApplicatio {
    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplicatio.class,args);
    }


}
