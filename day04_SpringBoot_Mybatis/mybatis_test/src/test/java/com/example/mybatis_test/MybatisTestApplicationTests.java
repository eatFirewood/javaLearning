package com.example.mybatis_test;

import com.example.mybatis_test.mapper.UserMapper;
import com.example.mybatis_test.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisTestApplicationTests {


    @Test
    public void testDeleteById(){
        userMapper.deleteById(1);
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }


    @Test
    void contextLoads() {
    }

}