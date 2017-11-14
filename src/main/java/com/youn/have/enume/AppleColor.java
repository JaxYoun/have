package com.youn.have.enume;

public enum AppleColor {

    RED("红色"),
    GREEN("绿色"),
    BLUE("蓝色");

    String name;

    AppleColor(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
