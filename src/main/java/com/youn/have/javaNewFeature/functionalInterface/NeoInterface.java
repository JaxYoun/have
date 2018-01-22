package com.youn.have.javaNewFeature.functionalInterface;

/**
 * @Author：YangJx
 * @Description：接口新特性测试
 * @DateTime：2018/1/22 9:27
 */
public class NeoInterface {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.fun();
        myClass.defaultMethod1();
        myClass.defaultMethod2();
        MyInterface.staticMethod1();
    }
}

interface MyInterface {

    int age = 12;

    String name = "杨建雄";

    static void staticMethod1() {
        System.out.println(age);
        System.err.println("staticMethod1");
    }

    static void staticMethod2() {
        System.out.println(name);
        System.err.println("staticMethod2");
    }

    default void defaultMethod1() {
        System.out.println(name);
        System.out.println("defaultMethod1");
    }

    default void defaultMethod2() {
        staticMethod1();
        System.out.println("defaultMethod2");
    }

    void fun();

}

class MyClass implements MyInterface {

    @Override
    public void fun() {
        System.out.println("fun");
    }

    @Override
    public void defaultMethod1() {
        System.out.println("实现类中覆盖defaultMethod1");
    }
}