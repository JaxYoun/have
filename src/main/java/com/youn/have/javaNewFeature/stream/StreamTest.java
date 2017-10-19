package com.youn.have.javaNewFeature.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Java 8 API添加了一个新的抽象称为流Stream，可让你以一种声明的方式处理数据。
 * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
 * Stream API可以极大提供Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 * 这种风格将要处理的元素集合看作一种流，流在管道中传输，并且可以在管道的节点上进行处理，比如筛选，排序，聚合等操作。
 * 元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到经过处理的结果。
 */
public class StreamTest {

    public static final List<Integer> list =Arrays.asList(2, 4 , 5, 8, 9);

    /**
     * 从结合构造串行流
     */
    public static void linerStream() {
        list.stream().filter( it -> it > 5 ).collect( Collectors.toList() ).forEach(System.out :: println);
    }

    /**
     * 从集合构造并行流
     */
    public static void parallelStream() {
        long count = list.parallelStream().filter(it -> it > 6).count();  //forEach(System.out :: println);
        System.out.print(count);
    }

    /**
     * 用foreach方法遍历集合
     */
    public static void forEach() {
        list.forEach(System.out :: println);
    }

    /**
     * Stream之map方法
     */
    public static void mapStream() {
        list.stream()
                .map(it -> it * it)
                .forEach(System.err :: println);
    }

    /**
     * Stream之filter方法
     */
    public static void streamFilter() {
        list.stream()
                .filter( it -> it > 5 )
                .forEach(System.err :: print);
    }

    /**
     * Stream之limit方法
     */
    public static void streamLimit() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out :: println);
    }

    /**
     * Stream之sorted方法
     */
    public static void streamSorted() {
        /*Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);*/
        List<String> stringList = Arrays.asList("google", "yahoo", "baidu", "alibaba");
        stringList.stream().sorted().forEach(System.out :: println);
    }

    /**
     * Stream之collectors方法
     */
    public static void streamCollectors() {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        List<String> filtered = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);

        String mergedString = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining("#\t"));
        System.out.println("合并字符串: " + mergedString);
    }

    /**
     * Stream之SummaryStatistics方法，用以统计分析
     */
    public static void streamSummaryStatistics() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    public static void main(String[] args) {
//        linerStream();
//        parallelStream();
//        forEach();
//        mapStream();
//        streamFilter();
//        streamLimit();
//        streamSorted();
//        streamCollectors();
        streamSummaryStatistics();
    }

}
