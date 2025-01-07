package com.example.spring_boot_mybatis_demo;

import com.example.spring_boot_mybatis_demo.mapper.UserMapper;
import com.example.spring_boot_mybatis_demo.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisDemoApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void selectAllfunction() {
        List<Student> students = userMapper.selectAll();
        students.forEach(System.out::println);
    }

    @Test
    public void insertFunction() {
        userMapper.insert("name", "no", 1, "phone", "idcard");
    }

    @Test
    public void deleteFunction() {
        userMapper.delete(1);

    }

    @Test
    public void updateFunction() {
        userMapper.update(3, "name2", "phone2", "idcard2");
    }
}