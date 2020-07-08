package com.atxzy.springcloud.service;

import com.atxzy.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "springcloud-provider-dept",fallbackFactory = DeptClientServiceFallbackFactory.class)
@Component("deptClientService")
public interface IDeptClientService {

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);

    @GetMapping("/dept/getList")
    public List<Dept> queryAll();

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept);
}
