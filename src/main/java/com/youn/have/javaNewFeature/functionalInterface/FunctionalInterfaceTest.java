package com.youn.have.javaNewFeature.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceTest {

    public static final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    /**
     * 定义一个方法，其参数包含一个Predicate型函数式接口，
     * 具体使用时，需传递一个实现了该函数是接口的对象
     * @param predicate
     */
    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(it -> {
            if(predicate.test(it)) {
                System.out.println(it);
            }
        });
    }

    /**
     * 判断元素存在性
     */
    public static void isExist() {
        /**
         * Predicate<Integer> predicate = (it) -> true; 也可以将【此对象】作为第二个参数，同义
         * it 是一个参数传递到 Predicate 接口的 test 方法
         * it 如果存在则 test 方法返回 true
         */
        eval(list, (it) -> true);  //高阶函数表达式
    }

    /**
     * 判断元素是否是偶数
     */
    public static void isEven() {
        /**
         * Predicate<Integer> predicate1 = (it) -> it % 2 == 0; 也可以将【此对象】作为第二个参数，同义
         * it 是一个参数传递到 Predicate 接口的 test 方法
         * 如果 it % 2 为 0 test 方法返回 true
         */
        eval(list, (it) -> it % 2 == 0);  //高阶函数表达式
    }

    /**
     * 判断元素是否大于3
     */
    public static void isGreaterThanThree() {
        /**
         * Predicate<Integer> predicate = (it) -> it > 3; 也可以将【此对象】作为第二个参数，同义
         * it 是一个参数传递到 Predicate 接口的 test 方法
         * 如果 it 大于 3 test 方法返回 true
         */
        eval(list, (it) -> it > 3);  //高阶函数表达式
    }

    public static void main(String[] args) {
        isExist();
        isEven();
        isGreaterThanThree();
    }

}
