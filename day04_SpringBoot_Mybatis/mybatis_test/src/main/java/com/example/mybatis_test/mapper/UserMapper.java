package com.example.mybatis_test.mapper;

import com.example.mybatis_test.pojo.User;
import org.apache.ibatis.annotations.*;

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

    @Insert("insert into user (id, username, password, name, age) values (#{id}, #{username}, #{password}, #{name}, #{age})")
    public int insert(@Param("id") String id, @Param("username") String username, @Param("password") String password, @Param("name") String name, @Param("age") Integer age);

    @Update("update user set password = #{password}, age = #{age} where id = #{id}")
    public int update(@Param("id") String id, @Param("password") String password, @Param("age") Integer age);

}