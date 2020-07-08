package com.atxzy.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient //
@EnableFeignClients(basePackages = {"com.atxzy.springcloud"})
public class springCloudConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(springCloudConsumerFeignApplication.class);
    }
}
