package com.cafebabe.clouddemo.zookeeper.consumer.controller.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Value("${test.config-name}")
    private String configName;

    @Value("${test.config-port}")
    private Integer configPort;

    @GetMapping("/getConfigName")
    public String getConfigName(){
        return configName;
    }

    @GetMapping("/getConfigPort")
    public Integer getConfigPort(){
        return configPort;
    }
}
