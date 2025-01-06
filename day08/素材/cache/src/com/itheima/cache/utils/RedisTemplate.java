package com.itheima.cache.utils;

import com.itheima.cache.inter.HashOperations;
import com.itheima.cache.inter.ValueOperations;
import com.itheima.cache.inter.impl.DefaultHashOperations;
import com.itheima.cache.inter.impl.DefaultValueOperations;

// 缓存工具类
public class RedisTemplate {

    // 操作值为String类型缓存工具类
    private final ValueOperations valueOperations = new DefaultValueOperations() ;

    // 操作值为HashMap类型缓存工具类
    private final HashOperations hashOperations = new DefaultHashOperations() ;

    // 获取操作值为String类型缓存工具类对象
    public ValueOperations opsForValue() {
        return valueOperations ;
    }

    // 获取操作值为HashMap类型缓存工具类
    public HashOperations opsForHash() {
        return hashOperations ;
    }

}
