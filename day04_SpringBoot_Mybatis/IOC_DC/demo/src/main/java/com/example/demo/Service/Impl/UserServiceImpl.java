package com.example.demo.Service.Impl;

import com.example.demo.Dao.UserDao;
import com.example.demo.Pojo.User;
import com.example.demo.Service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//注解将对象交给IOC管理
@Service
public class UserServiceImpl implements UserService {

    //注解按照类型自动装配，完成依赖注入
//    @Qualifier("userDaoImpl")
//    @Autowired

    @Resource(name = "userDaoImpl")
    UserDao userDao;
    @Override
    public List<User> function() throws IOException {
        List<String> stringList = userDao.func();

        List<User> users = new ArrayList<>();
        for (String string : stringList) {
            String[] split = string.split(",");

            User user = new User(Integer.parseInt(split[0]), split[1], split[2], split[3]);
            users.add(user);
        }
        return users;
    }
}
