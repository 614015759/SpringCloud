package com.atxzy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {  // @Configuration -- spring applicationContext.xml

    //配置负载均衡实现restTemplate
    @Bean
    @LoadBalanced  //Ribbon  基于客户端实现的
    public RestTemplate getRestTemplaste(){
        return new RestTemplate();
    }





}
