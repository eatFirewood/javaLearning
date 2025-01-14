package com.example.demo.Dao.Impl;

import com.example.demo.Dao.UserDao;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//注解提供IOC，将对象交给IOC容器管理
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public List<String> func() throws IOException {
        File file = new File("src/main/resources/user.txt");
        List<String> list = new ArrayList<>();

        List<String> strings = FileUtils.readLines(file);
        for(String str:strings){
            list.add(str);
        }
        return list;
    }
}
