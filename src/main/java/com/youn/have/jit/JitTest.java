package com.youn.have.jit;

import java.util.stream.IntStream;

/**
 * @Author：YangJx
 * @Description：Jit测试类
 * 用以在解释执行、编译执行、混合执行模式下测试各执行方式的速度
 * @DateTime：2018/1/11 23:53
 */
public class JitTest {

    public static void looper() {
        long start = System.currentTimeMillis();
        IntStream.range(1, 100000)
                .map(it -> it + 1)
                .forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.err.println(("执行耗时：" + (end - start) / 1000L) + "秒++++++++++");
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始------");
        looper();

        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        looper();
        System.out.println("又开始------");
    }

}