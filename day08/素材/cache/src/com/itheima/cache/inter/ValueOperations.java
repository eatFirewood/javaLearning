package com.itheima.cache.inter;

// Map的值是String类型的缓存工具类接口
public interface ValueOperations {

    // 存储数据
    public abstract void set(String key , String value) ;

    // 获取数据
    public abstract String get(String key) ;

}
