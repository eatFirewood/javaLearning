package com.itheima.consumer.entry;

import com.itheima.consumer.domain.Car;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Entry {

    public static void main(String[] args) {

        // 定义一个Car的数组
        Car[] cars = new Car[8] ;
        cars[0] = new Car("比亚迪-汉" , 27.95) ;
        cars[1] = new Car("奔驰-C级" , 37.22) ;
        cars[2] = new Car("宝马-3系" , 39.89) ;
        cars[3] = new Car("吉利-星越L" , 18.52) ;
        cars[4] = new Car("本田-思域" , 16.99) ;
        cars[5] = new Car("大众-帕萨特" , 25.09) ;
        cars[6] = new Car("奥迪A7L" , 77.77) ;
        cars[7] = new Car("标致-508" , 22.47) ;

        // 补全代码
        

    }

    // 条件删选遍历数组方法
    public static void forEach(Predicate<Car> predicate , Consumer<Car> consumer ,  Car[] cars) {
        for(Car car : cars) {
            if(predicate.test(car)) {
                consumer.accept(car);
            }
        }
    }

}
