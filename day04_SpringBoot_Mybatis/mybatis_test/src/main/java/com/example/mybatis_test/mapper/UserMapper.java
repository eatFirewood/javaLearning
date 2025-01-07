package com.example.mybatis_test.mapper;

import com.example.mybatis_test.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询全部
     */
    @Select("select * from user")
    public List<User> findAll();

    @Delete("delete from user where id = ${id}")
    public int deleteById(int id);

}