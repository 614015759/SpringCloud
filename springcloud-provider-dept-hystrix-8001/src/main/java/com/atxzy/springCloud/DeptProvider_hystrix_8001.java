package com.atxzy.springCloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//启动类
@MapperScan("com.atxzy.springCloud.mapper")
@SpringBootApplication
@EnableEurekaClient  //自动在服务启动后自动注册到eureka中
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker //添加对熔断的支持
public class DeptProvider_hystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_hystrix_8001.class);
    }
}
