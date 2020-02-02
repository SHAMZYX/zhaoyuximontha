package com.zhaoyuxi.zhaoyuxinacosgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZhaoyuxiNacosGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhaoyuxiNacosGatewayApplication.class, args);
    }

}
