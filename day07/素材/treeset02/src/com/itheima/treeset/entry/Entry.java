package com.itheima.treeset.entry;

import com.alibaba.excel.EasyExcel;
import com.itheima.treeset.domain.Sku;
import com.itheima.treeset.listener.SkuAnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class Entry {

    // 创建一个ArrayList集合对象，来存储读取到的excel/sku01.xlxs中的数据
    private static List<Sku> skus = new ArrayList<>();

    // 通过静态代码块执行初始化代码
    static  {

        // 读取数据到skus集合对象中
        EasyExcel.read("excel/sku01.xlsx" , Sku.class , new SkuAnalysisEventListener(skus)).sheet(0).doRead();

    }

    public static void main(String[] args) {

        // 查询商品编码为1000000031450088122的商品数据
        String sn = "1000000031450088122";

        // 从skus中根据商品的编码获取商品数据
        for(int x = 0 ; x < skus.size() ; x++) {
            Sku sku = skus.get(x) ;
            if(sku.getSn().equals(sn)) {
                System.out.println(sku);
                System.out.println("循环了(" + (x + 1) + ")次");
                break;
            }
        }

    }


}




