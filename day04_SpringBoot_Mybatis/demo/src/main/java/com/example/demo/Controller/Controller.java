package com.example.demo.Controller;

import com.example.demo.Pojo.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Component
public class Controller {
    @Autowired
    UserService userService;
    @RequestMapping("/test")
    public List<User> test() throws IOException {
        List<User> userList = userService.function();
        return userList;
    }
}
