package com.itheima.day08;

import java.util.*;

/**
 * @Author : eatfi
 * @Date : 2024/12/13 19:48
 */
public class CollectionTest {
    public static void main(String[] args) {
        int id = 0;

        HashMap<String, HashSet<String>> map = new HashMap<>();
        String[] arrString = new String[]{"电子工业出版社", "异步图书", "class3", "class4"};
        String[] arrString2 = new String[]{"a2", "b2", "c2", "d2"};
        String[] arrString3 = new String[]{"a3", "b3", "c3", "d3"};
        String[][] arrArr = new String[][]{arrString, arrString2, arrString3};

        for(String[] i : arrArr){
            HashSet<String> set = new HashSet<>();
            for(String j : i){
                set.add(j);
            }
            map.put(String.valueOf(id++), set);
        }
        Set<Map.Entry<String, HashSet<String>>> aSet = map.entrySet();
        aSet.forEach(o -> {
            System.out.printf("%s:", o.getKey());
            System.out.println(o.getValue());
        });
    }
}
