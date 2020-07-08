package com.atxzy.springCloud.controller;



import com.atxzy.springCloud.service.DeptService;
import com.atxzy.springcloud.pojo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供restfull服务
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrix_getById")
    public Dept getById(@PathVariable("id") long id){

        Dept dept = deptService.queryById(id);
        if(dept == null){
            throw  new RuntimeException("id=>"+id+",不存在该用户，或该用户无法找到");

        }
        return dept;
    }

    //备选方法
    public Dept hystrix_getById(@PathVariable("id") long id){


        return new Dept().setDeptno(id)
                .setDname("id=>"+id+"没有对应的信息，null--@Hystrix")
                .setDbSource("no this database in MySQL");
    }

}
