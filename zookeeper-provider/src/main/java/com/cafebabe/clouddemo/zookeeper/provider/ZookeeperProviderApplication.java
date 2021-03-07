package com.cafebabe.clouddemo.zookeeper.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.cafebabe.clouddemo.zookeeper.provider.dao"})
@EnableDiscoveryClient
public class ZookeeperProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperProviderApplication.class,args);
    }
}
