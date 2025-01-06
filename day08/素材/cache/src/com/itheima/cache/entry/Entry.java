package com.itheima.cache.entry;

import com.itheima.cache.utils.RedisTemplate;

public class Entry {

    public static void main(String[] args) {

        // 创建RedisTemplate对象
        RedisTemplate redisTemplate = new RedisTemplate() ;

        // 获取操作Map的值为String类型的操作对象,并存储数据
        redisTemplate.opsForValue().set("itheima" , "16");

        // 获取缓存中itheima对应的数据,并在控制台进行输出
        System.out.println(redisTemplate.opsForValue().get("itheima"));

        // 获取操作Map的值为HashMap类型的操作对象,并存储数据
        redisTemplate.opsForHash().put("user_1" , "name" , "黑马程序员");
        redisTemplate.opsForHash().put("user_1" , "age" , "16");

        // 获取缓存中user_info_1对应的数据,并在控制台进行输出
        System.out.println(redisTemplate.opsForHash().get("user_1" , "name"));
        System.out.println(redisTemplate.opsForHash().get("user_1" , "age"));
        System.out.println(redisTemplate.opsForHash().get("user_2" , "name"));

    }

}
