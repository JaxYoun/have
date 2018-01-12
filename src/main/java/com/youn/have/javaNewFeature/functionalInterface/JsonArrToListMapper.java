package com.youn.have.javaNewFeature.functionalInterface;

import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author：YangJx
 * @Description：
 * @DateTime：2018/1/8 11:06
 */
@Named("JsonArrToListMapper")
public class JsonArrToListMapper {

    @Value("${staticResourcePrix}")
    private static String staticResourcePrix = "#";

    private static Function<String, List<String>> fun = platArr -> {
        int len = platArr.length();
        return Arrays.asList(platArr.substring(1, len - 1).split(",")).stream().map(it -> {
            return staticResourcePrix + it;
        }).collect(Collectors.toList());
    };

    private static List<String> platArrToList(String platArr) {
        return fun.apply(platArr);
    }

    public static void main(String[] args) {
        platArrToList("[11,22]").forEach(System.out::print);
    }
}
