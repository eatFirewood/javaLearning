package com.example.demo.Dao;

import ch.qos.logback.core.util.FileUtil;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    public List<String> func() throws IOException;
}
