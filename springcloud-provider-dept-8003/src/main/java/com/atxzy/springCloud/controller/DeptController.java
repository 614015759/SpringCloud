package com.atxzy.springCloud.controller;



import com.atxzy.springCloud.service.DeptService;
import com.atxzy.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供restfull服务
@RestController
public class DeptController {

    @Autowired
    private DiscoveryClient discoveryClient;  //获取一些配置的信息  得到具体的微服务

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        boolean b = deptService.addDept(dept);
        return b;
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable(value = "id",required = true) Long id){
        Dept dept = deptService.queryById(id);
        return dept;
    }

    @GetMapping("/dept/getList")
    public List<Dept> getList(){
        List<Dept> depts = deptService.queryAll();
        return depts;
    }


//    注册进来的微服务~  获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取服务列表的清单
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        //得到一个具体的微服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-provider-dept");//通过具体的微服务id也就是applicationName
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+instance.getPort()+instance.getUri()+instance.getServiceId()
            );
        }
        return this.discoveryClient;
    }
}
