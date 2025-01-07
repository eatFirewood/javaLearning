package com.example.demo.Service.Impl;

import com.example.demo.Dao.UserDao;
import com.example.demo.Pojo.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
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
