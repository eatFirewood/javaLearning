package com.itheima.cache.inter;

// Map的值是HashMap类型的缓存工具类接口
public interface HashOperations {

    // 存储数据
    public abstract void put(String key , String hashKey , String value) ;

    // 获取数据
    public abstract String get(String key , String hashKey ) ;

}
