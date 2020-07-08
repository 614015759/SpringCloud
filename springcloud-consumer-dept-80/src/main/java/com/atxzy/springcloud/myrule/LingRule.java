package com.atxzy.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LingRule {

    @Bean
    public IRule myRandomRule(){
        return new RandomRule();
    }

}
