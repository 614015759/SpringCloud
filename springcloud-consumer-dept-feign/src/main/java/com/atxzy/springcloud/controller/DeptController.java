package com.atxzy.springcloud.controller;



import com.atxzy.springcloud.pojo.Dept;
import com.atxzy.springcloud.service.IDeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    //理解 消费者  不应该有Service层
    // RestTemplate ... 供我们直接调用即可  注册到spring容器中

    //(url,request
    //IRule
    //RoundRobinRule  轮询
    //RandomRule
    //RetryRule  : 会先按照轮询获取服务，如果服务获取失败，则会在指定的时间内进行重试
    //AvailabilityFilteringRule ： 会先过滤掉跳闸的服务  对剩下的进行轮询

    //使用ribbon做负载均衡的时候这里不应该写死，而应该是一个变量，通过服务名访问
    //private static final String REST_URL_PREFIX = "http://localhost:8001";


    @Autowired
    private IDeptClientService deptClientService ;


    @RequestMapping("/consumer/dept/add")
    public boolean add(@RequestBody Dept dept){
        return this.deptClientService.addDept(dept);
    }


    //localhost:8001/dept/list
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable(value = "id",required = true) Long id){
        return this.deptClientService.queryById(id);
    }

    @RequestMapping("/consumer/dept/getList")
    public List<Dept> getList(){
        return this.deptClientService.queryAll();
    }



}
