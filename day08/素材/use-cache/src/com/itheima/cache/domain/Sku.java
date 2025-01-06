package com.itheima.cache.domain;

import com.alibaba.excel.annotation.ExcelProperty;

public class Sku {

    @ExcelProperty("商品条码")
    private String sn ;             // 商品条码

    @ExcelProperty("商品名称")
    private String name ;           // 商品名称

    @ExcelProperty("商品价格")
    private Integer price ;         // 价格（分）

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
