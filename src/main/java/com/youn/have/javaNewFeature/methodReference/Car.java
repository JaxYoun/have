package com.youn.have.javaNewFeature.methodReference;

import java.util.*;
import java.util.function.Supplier;

public class Car {

    /**
     * 静态方法
     * @param supplier
     * @return
     */
    public static Car create(final Supplier< Car > supplier) {
        return supplier.get();
    }

    /**
     * 静态方法
     * @param car
     */
    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    /**
     * 非静态方法
     * @param another
     */
    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    /**
     * 非静态方法
     */
    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

//-----------------------------------------------------------------------

    public static void test() {
        /**
         * 构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下
         */
        final Car car = Car.create(Car :: new);
        final List< Car > cars = Arrays.asList(car);

        /**
         * 静态方法引用：它的语法是Class::static_method，实例如下：
         */
        cars.forEach(Car :: collide);

        /**
         * 特定类的任意对象的方法引用：它的语法是Class::method实例如下：
         */
        cars.forEach(Car :: repair);

        /**
         * 特定对象的方法引用：它的语法是instance::method实例如下：
         */
        final Car police = Car.create(Car :: new);
        cars.forEach(police :: follow);
    }

    /**
     * Map的foreach函数
     */
    public static void mapForeachFunction() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "2009043075");
        map.put("name", "YangJianxiong");
        map.put("age", "29");
        map.put("gender", "male");

        map.forEach((key, value) -> System.out.println(key + "=>" + value));
    }

    /**
     * List的foreach函数
     */
    public static void listForeachFunction() {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("1");
        list.add("4");
        list.add("3");

        list.forEach(it -> System.out.println(it));
    }

    /**
     * Set之foreach函数
     */
    public static void setForeachFunction() {
        Set<String> set = new HashSet<>();
        set.add("yang");
        set.add("jian");
        set.add("xiong");

        set.forEach(it -> System.out.println(it));
    }

    public static void main(String[] args) {
        Car.test();
        mapForeachFunction();
        listForeachFunction();
        setForeachFunction();
    }

}
