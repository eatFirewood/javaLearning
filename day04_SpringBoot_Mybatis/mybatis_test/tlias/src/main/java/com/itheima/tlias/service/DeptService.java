package com.itheima.tlias.service;

import com.itheima.tlias.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门
     */
    public List<Dept> findAll();
}