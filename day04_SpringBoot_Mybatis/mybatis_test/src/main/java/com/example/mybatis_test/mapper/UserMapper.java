package com.example.mybatis_test.mapper;

import com.example.mybatis_test.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findAll();

    public void delete();

    public int insert();
}