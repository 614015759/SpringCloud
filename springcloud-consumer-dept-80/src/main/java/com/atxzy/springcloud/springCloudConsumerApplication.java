package com.atxzy.springcloud;

import com.atxzy.springcloud.myrule.LingRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient //
@RibbonClient(name = "springcloud-provider-dept",configuration = LingRule.class) //在微服务启动的时候就能去加在我们自定义的Rule类
public class springCloudConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(springCloudConsumerApplication.class);
    }
}
