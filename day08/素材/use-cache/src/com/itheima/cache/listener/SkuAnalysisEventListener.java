package com.itheima.cache.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.itheima.cache.domain.Sku;

import java.util.List;

public class SkuAnalysisEventListener extends AnalysisEventListener<Sku> {

    // 定义List集合成员变量，来存储读取到的数据
    private List<Sku> skuList ;
    public SkuAnalysisEventListener(List<Sku> skuList) {
        this.skuList = skuList ;
    }

    @Override
    public void invoke(Sku sku, AnalysisContext context) {
        skuList.add(sku) ;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("磁盘excel数据读取完毕...");
    }
}
