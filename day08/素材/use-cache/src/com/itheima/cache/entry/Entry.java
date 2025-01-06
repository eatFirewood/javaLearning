package com.itheima.cache.entry;

import com.alibaba.excel.EasyExcel;
import com.itheima.cache.domain.Sku;
import com.itheima.cache.listener.SkuAnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class Entry {

    public static void main(String[] args) {

        // 调用getSkuBySn根据条码获取商品数据并在控制台进行输出
        for(int x = 0 ; x < 3 ; x++) {
            Sku sku = getSkuBySn("100000003145001000042");
            System.out.println(sku);
        }

    }

    // 根据商品的条码获取商品数据
    public static Sku getSkuBySn(String sn) {

        // 创建一个ArrayList集合对象，来存储读取到的excel/sku01.xlxs中的数据
        List<Sku> skus = new ArrayList<Sku>();

        // 读取数据到skus集合对象中
        EasyExcel.read("excel/sku01.xlsx" , Sku.class , new SkuAnalysisEventListener(skus)).sheet(0).doRead();

        // 遍历上述集合获取对应的商品数据进行返回
        Sku result = null ;
        for(Sku sku : skus) {
            if(sku.getSn().equals(sn)) {
                result = sku ;
                break;
            }
        }

        // 返回查询结果数据
        return result ;

    }

}
