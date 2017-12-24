package com.youn.have.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author：YangJx
 * @Description：线程池数量与关闭测试
 * @DateTime：2017/12/24 21:32
 */
@RestController
@RequestMapping("/threadPool")
public class ThreadPoolController {

    private static final ThreadPoolExecutor threadPool0 = new ThreadPoolExecutor(
            4,
            8,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy()
    );

    private static final ThreadPoolExecutor threadPool1 = new ThreadPoolExecutor(
            4,
            8,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy()
    );

    @PostMapping("/numThread")
    public void fiveThread() {
        IntStream.range(0, 10).forEach(it -> threadPool0.execute(() -> System.out.println(it)));
    }

    @PostMapping("/abcThread")
    public void sixThread() {
        IntStream.range(10, 20).forEach(it -> threadPool1.execute(() -> System.err.println(it)));
    }

    /*public static void main(String[] args) {
        for (int i : IntStream.range(0, 12).toArray()) {
            System.out.println(i);
        }
    }*/
}
