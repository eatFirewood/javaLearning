package com.itheima.day08;

import com.itheima.day02.A;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author : eatfi
 * @Date : 2024/12/13 20:23
 */
public class CoupleTest {
    public static void main(String[] args) {
        ArrayList<HashMap> arrayList = new ArrayList<>();
        String[] string1 = {"husband1", "wife1"};
        String[] string2 = {"husband2", "wife2"};
        String[] string3 = {"husband3", "wife3"};

        String[][] arrArr = {string1, string2, string3};
        for(String[] i : arrArr){
            HashMap<String, String> map = new HashMap<>();
            map.put(i[0], i[1]);
            arrayList.add(map);
        }
        for(HashMap i : arrayList){
            System.out.println(i);
        }

    }
}
