package com.itheima.consumer.domain;

public class Car {          // 汽车类

    private String name ;   // 汽车名称
    private double price ;  // 汽车价格，单位为万

    public Car(String name, double price) { // 有参构造方法
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
