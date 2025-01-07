package com.example.demo.Dao.Impl;

import com.example.demo.Dao.UserDao;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
public class UserDaoImpl2 implements UserDao {

    @Override
    public List<String> func() throws IOException {

        List<String> list = new ArrayList<>();
        String a = "4, aaa, 123456, eatfirewood@gmail.com";
        String b = "5, bbb, 123456, eatfirewood@gmail.com";
        list.add(a);
        list.add(b);

        return list;
    }
}