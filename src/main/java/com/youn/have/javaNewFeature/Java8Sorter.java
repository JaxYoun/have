package com.youn.have.javaNewFeature;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 比较Java8和Java7在一个排序程序中的语法差别
 */
public class Java8Sorter {

    private static final String[] arr7 = {"google", "yahoo", "baidu", "alibaba", "tencent"};
    private static final String[] arr8 = {"google", "yahoo", "baidu", "alibaba", "tencent"};

    /**
     * Java7排序方法
     *
     * @param list
     */
    public static void sortInJava7(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    /**
     * Java8排序方法
     *
     * @param list
     */
    public static void sortInJava8(List<String> list) {
        Collections.sort(list, (o1, o2) -> {
            return o1.compareTo(o2);
        });
    }

    public static void main(String[] args) {
        List<String> list7 = Arrays.asList(arr7);
        System.err.println(list7);
        sortInJava7(list7);
        System.out.println(list7);

        List<String> list8 = Arrays.asList(arr8);
        System.err.println(list8);
        sortInJava8(list8);
        System.out.println(list8);
    }

}