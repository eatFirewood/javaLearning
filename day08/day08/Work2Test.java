package com.itheima.day08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author : eatfi
 * @Date : 2024/12/13 20:17
 */
public class Work2Test {
    public static void main(String[] args) {
        String[] type = new String[]{"computer", "phone", "earphone"};

        HashMap<String, HashSet<String>> map = new HashMap<>();
        String[] arrString = new String[]{"a1", "b1", "c1", "d1"};
        String[] arrString2 = new String[]{"a2", "b2", "c2", "d2"};
        String[] arrString3 = new String[]{"a3", "b3", "c3", "d3", "e1", "f1"};
        String[][] arrArr = new String[][]{arrString, arrString2, arrString3};
        for(int i = 0; i < 3; i++){
            HashSet<String> set = new HashSet<>();
            for(String j : arrArr[i]){
                set.add(j);
            }
            map.put(String.valueOf(type[i]), set);
        }

        Set<Map.Entry<String, HashSet<String>>> aSet = map.entrySet();
        aSet.forEach(o -> {
            System.out.printf("%s:", o.getKey());
            System.out.println(o.getValue());
        });
    }
}
