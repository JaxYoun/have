package com.youn.have.sourcecode;

import com.youn.have.entity.User;

/**
 * @Author：YangJx
 * @Description：
 * @DateTime：2018/1/15 9:12
 */
public class StringTest {

    public static void main(String[] args) {
        System.out.println(ha("kkk"));
    }

    public static int ha (String input) {
        int hash = 0;
        char[] charArr = input.toCharArray();
        for(int i = 0; i < input.length(); i++) {
            hash = 31 * hash + charArr[i];
        }
        return hash;
    }

}