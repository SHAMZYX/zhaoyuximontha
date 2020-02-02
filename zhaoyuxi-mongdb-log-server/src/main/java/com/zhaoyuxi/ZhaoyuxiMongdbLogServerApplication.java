package com.zhaoyuxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZhaoyuxiMongdbLogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhaoyuxiMongdbLogServerApplication.class, args);
    }

}
