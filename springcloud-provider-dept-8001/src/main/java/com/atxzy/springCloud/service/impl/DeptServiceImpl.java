package com.atxzy.springCloud.service.impl;

import com.atxzy.springCloud.mapper.DeptMapper;

import com.atxzy.springCloud.service.DeptService;
import com.atxzy.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        int insert = deptMapper.insert(dept);

        return insert > 0;
    }

    @Override
    public Dept queryById(Long id) {
        Dept dept = deptMapper.selectById(id);
        return dept;
    }

    @Override
    public List<Dept> queryAll() {
        List<Dept> depts = deptMapper.selectList(null);
        return depts;
    }
}
