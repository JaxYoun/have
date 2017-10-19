package com.youn.have.javaNewFeature.defaultMethod;

import java.util.List;
import java.util.function.Supplier;

/**
 * Java 8 新增了接口的默认方法。
 * 简单说，默认方法就是接口可以直接拥有并实现的方法（可以多个），而且不需要实现类去实现这些方法。
 * 我们只需在方法名前面加个default关键字即可实现默认方法。
 *
 * 【注意】当一个实现类需要重写接口的默认方法是，也可以用default关键字重新定义属于实现类自己的默认方法！
 *
 * 为什么要有这个特性？
 * 首先，之前的接口是个双刃剑，好处是面向抽象而不是面向具体编程，
 * 缺陷是，当需要修改接口时候，需要修改全部实现该接口的类，比如：在java 8 之前的集合框架中没有foreach方法，
 * 通常能想到的解决办法是在JDK里给相关的集合接口添加新的方法及实现。然而，对于已经发布的版本，
 * 是没法在给接口添加新方法的同时而不影响已有实现的。所以才引进了默认方法。
 * 他们的目的就是是为了解决接口的修改与已有实现不兼容的问题。
 */
public class DefaultMethodTest {

    public static void main(String[] args) {
        Car car = Car.create(Car :: new);
        car.print();

        iVehicle.blowHorn();
    }

}

/**
 * 普通车接口
 */
interface iVehicle {
    /**
     * 接口之默认方法
     */
    default void print(){
        System.out.println("普通车接口\t我是一辆普通车!");
    }

    /**
     * 接口之静态方法，可以直接通过接口类调用
     */
    static void blowHorn(){
        System.out.println("普通车接口\t普通喇叭!");
    }
}

/**
 * 四轮车接口
 */
interface iFourWheeler {
    /**
     * 接口之默认方法
     */
    default void print(){
        System.out.println("四轮车接口\t我是一辆四轮车!");
    }
}

/**
 * 考虑这样的情况，一个类实现了多个接口，且这些接口有相同的默认方法，以下实例说明了这种情况的解
 */

class Truck implements iVehicle, iFourWheeler {
    @Override
    public void print() {

    }

    /**
     * 第一个解决方案是创建自己的默认方法，来覆盖重写接口的默认方法：
     */
    /*default void print() {
        System.out.println("我是一辆四轮汽车!");
    }*/
}

class Car implements iVehicle, iFourWheeler {

    /**
     * 静态方法
     * @param supplier
     * @return
     */
    public static Car create(final Supplier< Car > supplier) {
        return supplier.get();
    }

    /**
     * 第二种解决方案是使用 super 来调用指定接口的默认方法
     */
    @Override
    public void print() {
        iVehicle.super.print();
    }

}
