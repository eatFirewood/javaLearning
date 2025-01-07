package com.example.mybatis_test;

import com.example.mybatis_test.mapper.UserMapper;
import com.example.mybatis_test.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisTestApplicationTests {




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
    public void testDeleteById(){
        userMapper.deleteById(2);
    }

    @Test
    public void testInsert(){
        userMapper.insert("7", "aaa", "123456", "a", 20);
    }

    @Test
    public void testUpdate(){
        userMapper.update("7", "111b", 24);
    }


    @Test
    void contextLoads() {
    }

}
